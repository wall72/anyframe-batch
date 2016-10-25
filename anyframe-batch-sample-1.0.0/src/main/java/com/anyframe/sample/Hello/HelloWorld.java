/*                                                                           
 * Copyright 2010-2012 Samsung SDS Co., Ltd.                                 
 *                                                                           
 * Licensed under the Apache License, Version 2.0 (the "License");         
 * you may not use this file except in compliance with the License.          
 * You may obtain a copy of the License at                                   
 *                                                                           
 *     http://www.apache.org/licenses/LICENSE-2.0                            
 *                                                                           
 * Unless required by applicable law or agreed to in writing, software       
 * distributed under the License is distributed on an "AS IS" BASIS,       
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
 * See the License for the specific language governing permissions and       
 * limitations under the License.                                            
 *                                                                           
 */                                                                          

package com.anyframe.sample.Hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sds.anyframe.batch.core.item.support.AnyframeItemReaderFactory;
import com.sds.anyframe.batch.core.item.support.AnyframeItemWriterFactory;
import com.sds.anyframe.batch.core.step.tasklet.AnyframeAbstractTasklet;

/**                               
 * 								
 *                                
 * @author Hyoungsoon Kim         
 */								

public class HelloWorld extends AnyframeAbstractTasklet {
	
	private static final Log LOGGER = LogFactory.getLog(HelloWorld.class);

	public void execute(AnyframeItemReaderFactory readerFactory,
                        AnyframeItemWriterFactory writerFactory) throws Exception {

		LOGGER.debug("Hello World~!!");
	}
	
}
