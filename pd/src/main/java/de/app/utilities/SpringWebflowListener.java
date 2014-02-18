package de.app.utilities;

/**
 * @author 
 * ap420
 * Listener zum Debuggen des WebFlows
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.binding.expression.spel.SpringELExpression;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.engine.SubflowState;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.FlowSession;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.View;

import de.app.navigation.Navigation;
import de.app.navigation.NavigationItem;

/**
 * @author ap420
 */
public class SpringWebflowListener extends FlowExecutionListenerAdapter {

	private static final Logger LOGGER = Logger
			.getLogger(SpringWebflowListener.class);

	@Override
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
		// TODO Auto-generated method stub
		super.exceptionThrown(context, exception);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.webflow.execution.FlowExecutionListenerAdapter#
	 * stateEntered(org.springframework.webflow.execution.RequestContext,
	 * org.springframework.webflow.definition.StateDefinition,
	 * org.springframework.webflow.definition.StateDefinition)
	 */
	// Methode zum ermitteln des aktuellen Ausführungsschrittes
	public String getCurrentExecutionStepNumber(final RequestContext context) {
		String result = "";
		String flowExecutionUrl = context.getFlowExecutionUrl();
		if (StringUtils.isNotEmpty(flowExecutionUrl)) {
			result = flowExecutionUrl.substring(flowExecutionUrl
					.indexOf("execution=e") + 10);
			result = result.substring(result.indexOf("s") + 1);
		}
		return result;
	}

	@Override
	public void viewRendering(RequestContext context, View view,
			StateDefinition viewState) {
		// TODO Auto-generated method stub
		LOGGER.debug("viewRendering...");
		// Speichern des aktuellen Execution Steps in die Session um bei einer
		// Navigation über den Browser die Navigation anpassen zu können
		String currentExecutionStepNumber = "";
		if (StringUtils.isNotEmpty(context.getFlowExecutionUrl())) {
			currentExecutionStepNumber = getCurrentExecutionStepNumber(context);
		} else {
			// Es war der erste Request in dem Flow
			currentExecutionStepNumber = "1";
		}
		Navigation nav = (Navigation) context.getConversationScope().get(
				"navigation");
		// Könnte sein, dass es der Einstieg ist, weshalb die Navigation noch
		// nicht in der Session als Objekt gespeichert ist.
		// Deshalb hier an der Stelle eine null-Überprüfung
		if (nav != null) {
			for (int i = 0; i < nav.getItemList().size(); i++) {
				NavigationItem item = nav.getItemList().get(i);
				if (item.getName().equals(viewState.getId())) {
					item.setActive(true);
					List<String> temp = item.getStates();
					if (temp == null) {
						temp = new ArrayList<String>();
					}
					temp.add(currentExecutionStepNumber);
					item.setStates(temp);
				} else {
					item.setActive(false);
				}
			}
		}
		// super.viewRendering(context, view, viewState);
	}

	@Override
	public void viewRendered(RequestContext context, View view,
			StateDefinition viewState) {
		// TODO Auto-generated method stub
		// super.viewRendered(context, view, viewState);
	}

	@Override
	public void stateEntered(final RequestContext context,
			final StateDefinition previousState, final StateDefinition newState) {
		LOGGER.debug("stateEntered...");

		// Hier wird die Id des States in die Session gelegt, da das Objekt als
		// Ganzes nicht serialisiert werden kann und dies aber vom FlowScope
		// erwartet wird
		if (previousState != null
				&& (previousState.isViewState() || previousState instanceof SubflowState)) {
			context.getConversationScope().put("previousState",
					previousState.getId());
		}

		if (newState != null
				&& (newState.isViewState() || newState instanceof SubflowState)) {
			LOGGER.debug("Entered State:" + newState.getId());
			context.getConversationScope()
					.put("currentState", newState.getId());

			// Falls ein Modelattribut übergeben worden ist, muss es in die
			// Session gespeichert werden um später
			// festzustellen ob ein Sprung nach "vorne" in der Navigation
			// erlaubt ist

			// Aktuell wird im Formular das Hidden-Input Feld unter dem Key
			// "formModel" übergeben um den Namen des Models des Formulars zu
			// kennen
			// Mit dem Namen lässt sich über den Flow Scope und dessen
			// AttributeMap auf das Model zugreifen und
			// in der Session unter dem Key "model" speichern um bei der
			// (submit)Transition das aktuelle Model mit dem abgesendeten Model
			// zu vergleichen
			// je nachdem ob etwas am Model geändert worden ist, darf der Kunde
			// dann an die gewünschte Stelle navigieren.
			if (context.getCurrentState() != null
					&& context.getCurrentState().getAttributes().size() > 0) {
				// Hier findet man unter dem Key "model" den im View-State
				// verwendeten Modelnamen (+Scope)
				SpringELExpression formModelExpression = (SpringELExpression) context
						.getCurrentState().getAttributes().asMap().get("model");
				String formModel = formModelExpression.getExpressionString();
				if (StringUtils.isNotEmpty(formModel)) {
					Map<String, Object> currentStateMap = context
							.getConversationScope().asMap();

					String temp = formModel.substring(formModel
							.lastIndexOf(".") + 1);
					// Key unter dem das Model in der Map liegt
					context.getConversationScope().put("modelKey", temp);

					Object model = currentStateMap.get(temp);
					if (model != null) {
						context.getConversationScope().put("oldModel",
								model.toString());
					}
				}
			}
			// Navigation aktualisieren - sofern der newState kein SubFlowState
			// ist
			// Bei einem Subflow wird eine neue FlowSession gestartet und die
			// Navigation deren würde nur genau die States aus dem Subflow
			// enthalten
			// Falls der aktuelle Flow einen Parent hat, ist es ein Subflow und
			// die Navigation darf nicht aktualisiert werden
			if (!(newState instanceof SubflowState)) {
				Navigation nav = (Navigation) context.getConversationScope()
						.get("navigation");
				// Könnte sein, dass es der Einstieg ist, weshalb die Navigation
				// noch nicht in der Session als Objekt gespeichert ist.
				// Deshalb hier an der Stelle eine null-Überprüfung
				if (nav != null) {
					for (int i = 0; i < nav.getItemList().size(); i++) {
						NavigationItem item = nav.getItemList().get(i);
						if (item.getName().equals(newState.getId())) {
							item.setActive(true);
							item.setReachable(true);
							item.setActive(true);
						} else if (item.getName().equals(
								context.getConversationScope().get(
										"previousState"))) {
							item.setActive(false);
						}
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.webflow.execution.FlowExecutionListenerAdapter#
	 * sessionStarted(org.springframework.webflow.execution.RequestContext,
	 * org.springframework.webflow.execution.FlowSession)
	 */
	@Override
	public void sessionStarted(final RequestContext context,
			final FlowSession session) {
		LOGGER.debug("sessionStarted...");
	}

	@Override
	public void sessionStarting(RequestContext context, FlowSession session,
			MutableAttributeMap<?> input) {
		LOGGER.debug("sessionStarting...");
		FlowDefinition definition = session.getDefinition();

		if (definition instanceof Flow && session.getParent() == null) {
			Flow flow = (Flow) definition;
			Navigation nav = new Navigation();
			String[] stateIds = flow.getStateIds();
			List<NavigationItem> items = new LinkedList<NavigationItem>();
			boolean isViewState;
			for (int i = 0; i < stateIds.length; i++) {
				StateDefinition state = context.getActiveFlow().getState(
						stateIds[i]);

				// View-States und Substates müssen in die Navigation übernommen
				// werden
				isViewState = (state.isViewState() || state instanceof SubflowState)
						&& !state.getId().startsWith("error");
				boolean isAuthentificationRequired = false;
				int positionAntragsstreckeStart = 0;
				if (i != 0 && i >= positionAntragsstreckeStart) {
					isAuthentificationRequired = true;
				}
				if (isViewState) {
					if (state.getId().equals("anmeldung")) {
						positionAntragsstreckeStart = ++i;
					}
					String currentState = (String) context
							.getConversationScope().get("currentState");
					NavigationItem item = new NavigationItem();
					if (!StringUtils.isNotEmpty(currentState) && i == 0) {
						item.setActive(true);
						item.setReachable(true);
					}
					item.setAuthenticationRequired(isAuthentificationRequired);
					item.setName(stateIds[i]);
					item.setDisplayName(PropertyUtilities
							.getFlowProperties(stateIds[i]));
					items.add(item);
				}
			}
			nav.setItemList(items);
			context.getConversationScope().put("navigation", nav);
		}
	}

	@Override
	public void requestSubmitted(RequestContext context) {
		LOGGER.debug("requestSubmitted...");
	}
}
