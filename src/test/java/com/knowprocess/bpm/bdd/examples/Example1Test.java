/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * BPM Behaviour Driven Development (BDD) library
 * Copyright 2015 Tim Stephenson
 * 
 *******************************************************************************/
package com.knowprocess.bpm.bdd.examples;

import com.knowprocess.bpm.bdd.BpmSpec;
import org.flowable.engine.test.FlowableRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Simplest possible example specification using BPM BDD.
 *
 * @author Tim Stephenson
 */
public class Example1Test {

    private static final String EXAMPLE1_KEY = "Example1";

    @Rule
    public FlowableRule flowableRule = new FlowableRule("test-flowable.cfg.xml");

    @SuppressWarnings("unchecked")
    @Test
    @org.flowable.engine.test.Deployment(resources = { "processes/Example1.bpmn" })
    public void testExample1() throws Exception {
        new BpmSpec(flowableRule, "testExample1")
                .given("No particular pre-conditions")
                .whenEventOccurs("The Example1 process is started",
                        EXAMPLE1_KEY, BpmSpec.buildSet(),
                        BpmSpec.buildMap(), null)
                .thenUserTask("doSomething", BpmSpec.buildSet(),
                        BpmSpec.buildMap())
                .thenProcessIsComplete();

    }

}
