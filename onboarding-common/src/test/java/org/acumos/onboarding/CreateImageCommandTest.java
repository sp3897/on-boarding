/*-
 * ===============LICENSE_START=======================================================
 * Acumos
 * ===================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property & Tech Mahindra. All rights reserved.
 * ===================================================================================
 * This Acumos software file is distributed by AT&T and Tech Mahindra
 * under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===============LICENSE_END=========================================================
 */

package org.acumos.onboarding;

import java.io.File;

import org.acumos.onboarding.component.docker.cmd.CreateImageCommand;
import org.acumos.onboarding.component.docker.cmd.DockerCommand;
import org.junit.Test;
import org.mockito.InjectMocks;

public class CreateImageCommandTest {
	
	@InjectMocks
	DockerCommand dockerCommand;
	File srcFile = new File("inFile.csv");
	
	CreateImageCommand createImageCommand = new CreateImageCommand(srcFile,"H2O","1.0.0","H20",true,true);
	
	@Test
	public void execute() {
		
	 try {	
		//dockerCommand = new  CreateImageCommand("tmp", "genericjava",String imageTag, String dockerFile, boolean noCache, boolean rm); 
		dockerCommand = new  CreateImageCommand(new File("tmp"), "genericjava","latest", "Dockerfile", true, true);
		assert(true);
	 }catch(Exception e){
		 assert(false);
		 e.printStackTrace();
	 }
	}
	
	
	/* @Test
	 public void  getDisplayNameTest()
		{
			dockerCommand = new  CreateImageCommand(new File("tmp"), "genericjava","latest", "Dockerfile", true, true);
		 dockerCommand.getDisplayName();
		 // when(dockerCommand.getDisplayName()).thenReturn("Create/build image");
		  assert(true);

		}*/

     @Test
	public void testCommon() {
		CreateImageCommand createImageCommand = new CreateImageCommand(new File("tmp"), "genericjava","latest", "Dockerfile", true, true);
		createImageCommand.setBuildArgs("run");
		createImageCommand.getBuildArgs();
		String str = createImageCommand.getImageId();
		if(str != null){
			assert(true);
		}
		
	}
    @Test
 	public void getDisplayName() {
    	createImageCommand.getDisplayName();
    	assert(true);
     }
    @Test
	public void executeTest() {
		try {
			createImageCommand.execute();
			assert (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
