package com.knowprocess.bpm.bdd.ext;

import java.util.List;

import com.knowprocess.bpm.bdd.BpmSpec;
import com.knowprocess.bpm.bdd.ExternalAction;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricDetail;
import org.flowable.engine.test.FlowableRule;

public class DumpAuditTrail implements ExternalAction {

    private final FlowableRule flowableRule;

    /**
     * @param flowableRule
     */
    public DumpAuditTrail(FlowableRule flowableRule) {
        this.flowableRule = flowableRule;
    }

    public void execute(BpmSpec spec) throws Exception {
        System.out.println("Audit trail: ");

        List<HistoricActivityInstance> activities = flowableRule
                .getHistoryService().createHistoricActivityInstanceQuery()
                .processInstanceId(spec.getProcessInstance().getId()).list();

        for (HistoricActivityInstance hist : activities) {
            System.out.println(String.format("  : %1$s", hist));
        }

        System.out.println("Final data: ");
        List<HistoricDetail> details = flowableRule
                .getHistoryService().createHistoricDetailQuery()
                .processInstanceId(spec.getProcessInstance().getId()).list();

        for (HistoricDetail hist : details) {
            System.out.println(String.format("  : %1$s", hist));
        }
    }
}
