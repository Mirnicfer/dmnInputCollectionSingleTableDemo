package org.jit;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.stereotype.Component;


@Component("payloadProcessor")
public class PayloadProcessor implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(PayloadProcessor.class.getName());
  private static final String GUESTS_NODE_NAME = "guests";
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "activityName='" + execution.getCurrentActivityName() + "'"
            + ", variables=" + execution.getVariables()
            + " \n\n");

    SpinJsonNode list = (SpinJsonNode) execution.getVariable("list");
    LOGGER.info("has prop guests? "+ list.hasProp(GUESTS_NODE_NAME) + " \n"+
            "is guests an array " + list.prop(GUESTS_NODE_NAME).isArray() + " \n"+
            "guest elements: " + list.prop(GUESTS_NODE_NAME).elements()
            );

    /*
    Optional, extract the element 'guests' of the json payload using a SpinJsonNode,
    and set it as variable in the process. This way we can make the expression less technical,
    meaning not parting the json in the expression of the DMN
    i.e. avoiding writing: ' S(list).prop('guests') '
    execution.setVariable("listJSON", list.prop(GUESTS_NODE_NAME));
    */

  }

}
