/**
* <p>
* @Title: Department.java
* <p>
* @Package com.oceansoft.domain
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午2:58:03
* <p>
*/
package com.oceansoft.domain;

/**
 * @Description: 部门实体类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午2:58:03
 */
public class Department {

	private String deptName;

	private Integer id;
	private String remark;

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", remark=" + remark + "]";
	}


}
