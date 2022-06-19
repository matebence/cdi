package scope.flow;

import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import javax.faces.flow.builder.FlowBuilder;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import java.io.Serializable;

public class ComputerFlow implements Serializable {

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "computer";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
        flowBuilder.returnNode("returnFromFlow").fromOutcome("/scope/computerOne");

        return flowBuilder.getFlow();
    }
}
