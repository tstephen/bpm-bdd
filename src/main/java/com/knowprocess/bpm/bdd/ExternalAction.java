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
package com.knowprocess.bpm.bdd;

/**
 * Extension interface allowing specification to include custom behaviour in
 * addition to process engine calls.
 *
 * @author Tim Stephenson
 */
public interface ExternalAction {

    /**
     * @param spec
     *            Access all process engine services as well as scenario
     *            specification.
     * @throws Exception
     *             If scenario does not execute as expected.
     */
    void execute(BpmSpec spec) throws Exception;
}
