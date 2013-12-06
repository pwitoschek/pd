/**
 * 
 */
package de.app.utilities;

import org.apache.log4j.Logger;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.definition.TransitionDefinition;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;

/**
 * @author pd
 * 
 */
public class SpringWebflowListener extends FlowExecutionListenerAdapter {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void stateEntered(RequestContext context,
			StateDefinition previousState, StateDefinition newState) {
		logger.debug("Entered State:" + newState.getId());
		context.getFlowScope().put("tabpanel", "test");
		// context.getFlowScope().get(attributeName)
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
	}

}
