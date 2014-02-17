/**
 * 
 */
package de.app.exception;

import org.springframework.webflow.execution.FlowExecutionKey;
import org.springframework.webflow.execution.repository.FlowExecutionRestorationFailureException;

/**
 * @author pd
 * 
 */
public class CustomFlowExecutionException extends
		FlowExecutionRestorationFailureException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5257159606862134035L;

	public CustomFlowExecutionException(FlowExecutionKey flowExecutionKey,
			Exception cause) {
		super(flowExecutionKey, cause);
		// TODO Auto-generated constructor stub
	}

}
