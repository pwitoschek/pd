/**
 * 
 */
package de.app.utilities;

import java.text.MessageFormat;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.definition.TransitionDefinition;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.FlowSession;
import org.springframework.webflow.execution.RequestContext;

import de.app.navigation.Navigation;
import de.app.navigation.NavigationItem;

/**
 * @author pd
 * 
 */
public class SpringWebflowListener extends FlowExecutionListenerAdapter {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void sessionStarted(RequestContext context, FlowSession session) {
		FlowDefinition definition = session.getDefinition();
		if (definition instanceof Flow) {
			String execParam = context.getExternalContext()
					.getRequestParameterMap().get("execution");
			Flow flow = (Flow) definition;
			Navigation nav = new Navigation();
			flow.getId();
			String executionNumber = "";
			if (execParam == null) {
				executionNumber = "e1";
			} else {
				executionNumber = "e"
						+ execParam.substring(1, execParam.indexOf("s") - 1);
			}
			String[] stateIds = flow.getStateIds();
			LinkedList<NavigationItem> items = new LinkedList<NavigationItem>();
			for (int i = 0; i < stateIds.length; i++) {
				String executionStep = "s" + (i + 1);
				NavigationItem item = new NavigationItem();
				if (i == 0) {
					item.setActive(true);
					item.setReachable(true);
				}
				item.setName(stateIds[i]);
				item.setExecutionStep(executionStep);
				item.setExecutionNumber(executionNumber);
				item.setUri(executionNumber + executionStep);
				items.add(item);
			}
			nav.setItemList(items);
			// context.getExternalContext().getFlowExecutionUrl(flowId,
			// flowExecutionKey)
			// session.getViewScope().put("navigation", nav);
			context.getFlowScope().put("navigation", nav);
		}
	}

	@Override
	public void sessionCreating(RequestContext context,
			FlowDefinition definition) {
		logger.debug("SessionCreating");
	}

	@Override
	public void stateEntered(RequestContext context,
			StateDefinition previousState, StateDefinition newState) {
		logger.debug("Entered State:" + newState.getId());
	}

	@Override
	public void transitionExecuting(RequestContext context,
			TransitionDefinition transition) {
		logger.debug("Executing transition:" + transition.getId());
	}

	@Override
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
		super.exceptionThrown(context, exception);
		logger.error("Webflow " + context.getActiveFlow().getId()
				+ " threw exception in " + context.getCurrentState().getId(),
				exception);
	}

	@Override
	public void requestSubmitted(RequestContext context) {
		logger.debug("Request submitted" + context.getFlowExecutionUrl());
		Navigation nav = null;
		try {
			if ((context.getFlowScope() != null)
					&& (context.getFlowScope().get("navigation") != null)) {
				nav = (Navigation) context.getFlowScope().get("navigation");
				String executionRequestParameter = context.getExternalContext()
						.getRequestParameterMap().get("execution");
				MessageFormat format = new MessageFormat("e{0}s{1}");
				Object[] executionParams = format
						.parse(executionRequestParameter);

				for (int i = 0; i < nav.getItemList().size(); i++) {
					MessageFormat requestUriFormat = new MessageFormat("{0}=");
					Object[] requestUriParams = requestUriFormat.parse(context
							.getFlowExecutionUrl());
					System.out.println((String) requestUriParams[0]);
					NavigationItem item = nav.getItemList().get(i);
					item.setExecutionNumber((String) executionParams[0]);
					item.setUri((String) executionParams[0]);
					item.setUri((String) requestUriParams[0] + "=e"
							+ item.getExecutionNumber()
							+ item.getExecutionStep());
					System.out.println(item.getUri());
					logger.debug("Request submitted - " + item.getName() + ": "
							+ item.getUri());
				}
			}
		} catch (Exception e) {
			logger.debug(e.toString());
		}
	}
}
