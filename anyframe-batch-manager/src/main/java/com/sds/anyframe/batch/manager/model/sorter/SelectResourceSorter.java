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

/**
 * 
 */
package com.sds.anyframe.batch.manager.model.sorter;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;

import com.sds.anyframe.batch.manager.dialog.JobDetailInfoDialog;
import com.sds.anyframe.batch.manager.dialog.ResourceAndFile;

/**                               
 * 								
 *                                
 * @author Byungho Park         
 */								

public class SelectResourceSorter extends ViewerSorter {

	private String column = null;

	private int dir = SWT.DOWN;
	/**
	 * @param column
	 * @param dir
	 */
	public SelectResourceSorter(String column, int dir) {
		super();
		this.column = column;
		this.dir = dir;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int returnValue = 0;
		int col = ArrayUtils.indexOf(JobDetailInfoDialog.resourceColumnHeaders, column);

		Object val1 = JobDetailInfoDialog.getResourceColumnTextFromTable((ResourceAndFile)e1, col);
		Object val2 = JobDetailInfoDialog.getResourceColumnTextFromTable((ResourceAndFile)e2, col);
		
		if(Comparable.class.isAssignableFrom(val1.getClass())) {
			returnValue = ((Comparable)val1).compareTo(val2);
		}
		
		if (this.dir == SWT.DOWN)
			returnValue = returnValue * -1;
		
		return returnValue;
	}

}
