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

package com.anyframe.sample.SAMFile2SAMFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.anyframe.sample.CreateData.Vo.EmployeeListVo;
import com.sds.anyframe.batch.common.util.MessageFormatter;
import com.sds.anyframe.batch.core.item.support.AnyframeItemReader;
import com.sds.anyframe.batch.core.item.support.AnyframeItemReaderFactory;
import com.sds.anyframe.batch.core.item.support.AnyframeItemWriter;
import com.sds.anyframe.batch.core.item.support.AnyframeItemWriterFactory;
import com.sds.anyframe.batch.core.step.tasklet.AnyframeAbstractTasklet;

/**
 * 입력 데이터로부터 Employee 데이터를 획득하여 Employee의 사번(no)이 50보다 큰 경우만
 * 결과 파일에 기록하는 샘플용 배치 작업
 * 
 * <p><i>모든 배치작업용 클래스는 AnyframeAbstractTasklet를 상속해야 하며 
 * abstract 메써드로 정의된 execute() 메써드를 오버라이딩 해야 함. </i>
 * 
 * @author Hyoungsoon Kim
 */

public class ProcessData extends AnyframeAbstractTasklet {
	
	private static final Log LOGGER = LogFactory.getLog(ProcessData.class);
	private MessageFormatter message = new MessageFormatter();
	
	/**
	 * @name_ko 배치 본처리 프로그램
	 */
	@Override
	public void execute(AnyframeItemReaderFactory readerFactory,
                        AnyframeItemWriterFactory writerFactory) throws Exception {
      
      	/*--------------------------------------------------
    	 * @fd_do_start Reader/Writer 세팅
    	 * @fd_id 0001
    	 --------------------------------------------------*/
		AnyframeItemWriter writer = writerFactory.getItemWriter("writer");
		AnyframeItemReader reader = readerFactory.getItemReader("reader", new EmployeeListVo());
		/*--------------------------------------------------
		 * @fd_do_end 0001
		 --------------------------------------------------*/

		EmployeeListVo listVo = new EmployeeListVo();
		/*--------------------------------------------------
		 * @fd_do_start 샘플 프로그램 본처리
		 * @fd_id 0002
		 --------------------------------------------------*/

		// reader로부터 VO를 순차적으로 읽어들임(파일 끝에 도달한 경우 null을 반환함) 
		while((listVo = (EmployeeListVo) reader.read()) != null ) {
			
		
			/*--------------------------------------------------
			 * @fd_if 고용자 사번이 50보다 큰 경우에만 결과파일에 기록하는 로직
			 * @fd_id 0003
			 --------------------------------------------------*/ 			
			if(listVo.getNumber() >= 50) {
				// 필요한 경우 Logg
				LOGGER.debug("Employee: " + listVo);
				writer.write(listVo);
			}
			
		}
		/*--------------------------------------------------
		 * @fd_do_end 0002
		 --------------------------------------------------*/
		/*--------------------------------------------------
		 * @fd_do_start 처리 결과 기록
		 * @fd_id 0004
		 --------------------------------------------------*/

		// LOGGER를 사용하는 것과 달리 MessageFormatter를 사용할 경우 Log 레벨과 상관 없이 결과를 로그에 기록함.
 		// 따라서 개발/운영계에 로그레벨이 달라지는 경우에도 출력을 보장함
 		message.print("########## 배치 실행 결과 ##########");
 		message.print("## READ  횟수 : " + reader.getItemCount());
		message.print("## WRITE 횟수 : " + writer.getItemCount());
		message.print("########################################");
		/*--------------------------------------------------
		 * @fd_do_end 0004
		 --------------------------------------------------*/

	}
	
}
