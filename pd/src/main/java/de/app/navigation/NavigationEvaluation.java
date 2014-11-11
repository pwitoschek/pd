/**
 * 
 */
package de.app.navigation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.FlowExecutionKey;
import org.springframework.webflow.execution.FlowSession;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

/**
 * Zentrale Stelle um den Sprung in der Navigationsleiste zu validieren. </br>
 * <a href=
 * "http://docs.spring.io/spring-webflow/docs/2.0.x/reference/htmlsingle/spring-webflow-reference.html#el-variables"
 * >Spring EL-Variablen</a> zeigt m�gliche �bergabeparameter in den ActionStates
 */
@Component
public class NavigationEvaluation {

	private static final Logger LOGGER = Logger
			.getLogger(NavigationEvaluation.class);

	/**
	 * Diese Methode validiert die Navigation - ist ein Sprung auf das
	 * gew�nschte Ziel �berhaupt erlaubt bzw. wurde das Model ver�ndert?!
	 * 
	 * @param session
	 * @param targetViewState
	 * @param key
	 * @param definition
	 * @param event
	 * @return
	 */
	public Event evaluate(final FlowSession session,
			final String targetViewState, final FlowExecutionKey key,
			final FlowDefinition definition, final Event event) {
		String result = "success";
		RequestContext ctx = RequestContextHolder.getRequestContext();
		MutableAttributeMap<Object> scope = ctx.getConversationScope();
		Object object = scope.get("target");
		String previousState = (String) scope.get("previousState");
		boolean mustCompareModels = false;
		boolean modelChanged = false;
		int positionPreviousState = 0;
		int positionTargetState = 0;
		Navigation nav = null;
		try {
			if (scope.get("navigation") != null) {
				nav = (Navigation) scope.get("navigation");
				for (int i = 0; i < nav.getItemList().size(); i++) {
					NavigationItem item = nav.getItemList().get(i);
					if (item.getName().equals(previousState)) {
						positionPreviousState = i;
					} else if (item.getName().equals(targetViewState)) {
						positionTargetState = i;
					}
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.toString());
		}

		// Falls die gew�nschte View (mind. 2 Positionen) vor der aktuellen View
		// liegt, muss das Model validiert werden
		mustCompareModels = positionTargetState > positionPreviousState + 1;

		// Falls das aktuelle Model von dem SessionModel abweicht, ist das ein
		// Indiz, dass der Kunde etwas ge�ndert hat,
		// weshalb er "nur" auf die n�chste View navigieren darf
		if (mustCompareModels) {
			// Zwischengespeicherte Model (als String-Repr�sentation - zum
			// einfacheren Vergleich)
			// in der Session (eventuell alter Stand - muss mit aktuellen
			// abgeglichen werden)
			String modelKey = (String) scope.get("modelKey");
			String currentModelString = "";
			if (StringUtils.isNotEmpty(modelKey)) {
				currentModelString = scope.get(modelKey).toString();
			}
			String sessionModelString = (String) scope.get("oldModel");
			modelChanged = !currentModelString.equals(sessionModelString);
		}
		// Auf n�chstes View navigieren, falls sich das Model ge�ndert hat und
		// ein in der Navigation weiter vorne liegendes Tab angefordert worden
		// ist
		if (mustCompareModels && modelChanged && nav != null) {
			scope.put("target", nav.getItemList()
					.get(positionPreviousState + 1).getName());
			// Alle nachfolgenden NavItems auf nicht erreichbar setzen
			for (int i = positionPreviousState + 2; i < nav.getItemList()
					.size(); i++) {
				nav.getItemList().get(i).setReachable(false);
			}
		}
		return new Event(this, result);
	}

}
