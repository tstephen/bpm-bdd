package com.knowprocess.bpm.bdd.assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.runtime.ProcessInstance;

public class BpmAssert {

    public static ProcessEngine processEngine;

    protected static ProcessEngine getProcessEngine() {
        if (processEngine == null) {
            throw new IllegalStateException(
                    "You must set the process engine before invoking assertions");
        }
        return processEngine;
    }

    public static void assertProcessEndedAndInExclusiveEndEvent(
            ProcessInstance processInstance, String endEventId) {
        assertEquals(endEventId,
                getProcessEngine().getHistoryService()
                        .createHistoricProcessInstanceQuery()
                        .processInstanceId(processInstance.getId())
                        .singleResult().getEndActivityId());
    }

    public static void assertProcessVariableLatestValueEquals(
            ProcessInstance processInstance, String key, Object value) {
        assertEquals(value, getProcessEngine().getRuntimeService()
                .getVariableInstance(processInstance.getId(), key));
    }

    public static void assertProcessEnded(ProcessInstance processInstance) {
        assertNotNull(getProcessEngine().getHistoryService()
                .createHistoricProcessInstanceQuery()
                .processInstanceId(processInstance.getId()).singleResult()
                .getEndTime());
    }

    public static void assertProcessEndedAndInEndEvents(
            ProcessInstance processInstance, String[] endEventIds) {
        // TODO Auto-generated method stub

    }

}
