/**
 * 
 */
package de.app.navigation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.execution.RequestContext;

/**
 * @author ap420
 */
@Component
public class NavigationService {

	private static final Logger LOGGER = Logger
			.getLogger(NavigationService.class);

	// Diese Methode ermittelt anhand des aktuellen Flows, ob der angeforderte
	// View-State in der Navigation nach dem aktuellen View-State liegt.
	public boolean isRequestedNavigationItemAfterCurrent(
			final RequestContext context, final StateDefinition previousState,
			final StateDefinition newState) {
		int previousStateNumber = 0;
		int newStateNumber = 0;
		try {
			if ((context.getFlowScope() != null)
					&& (context.getFlowScope().get("navigation") != null)) {
				Navigation nav = (Navigation) context.getFlowScope().get(
						"navigation");

				for (int i = 0; i < nav.getItemList().size(); i++) {
					NavigationItem item = nav.getItemList().get(i);
					if (item.getName().equals(previousState.getId())) {
						previousStateNumber = i;
					} else if (item.getName().equals(newState.getId())) {
						newStateNumber = i;
					}
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.toString());
		}

		return (previousStateNumber < newStateNumber);
	}

}
