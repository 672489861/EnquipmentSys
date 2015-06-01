/**
* <p>
* @Title: PageBean.java
* <p>
* @Package com.oceansoft.util
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午11:59:39
* <p>
*/
package com.oceansoft.util;

import com.oceansoft.common.Constants;

/**
 * @Description: 分页工具类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午11:59:39
 */
public class PageBean {

	private int page; // 第几页
	private int pageSize = Constants.pageSize; // 每页记录数

	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getStart() {
		return (page - 1) * pageSize;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
