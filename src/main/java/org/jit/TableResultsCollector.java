package org.jit;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("tableResultsCollector")
public class TableResultsCollector implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {


        String singleResult = (String) delegateExecution.getVariable("dish");
        List<String> combinedResults = (List<String>)delegateExecution.getVariable("combinedResults");

        if (combinedResults == null){
            combinedResults = new ArrayList<>();
        }

        combinedResults.add(singleResult);
        delegateExecution.setVariable("combinedResults", combinedResults);

        //not in scope of this demo, translate the object to Json
    }
}