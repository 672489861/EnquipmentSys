/**
* <p>
* @Title: User.java
* <p>
* @Package com.oceansoft.domain
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午2:54:51
* <p>
*/
package com.oceansoft.domain;

/**
 * @Description: 用户实体类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午2:54:51
 */
public class User {

	private Department department;
	private Integer id;
	private String password;
	private String roleName;

	private String trueName;

	private String userName;
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", trueName=" + trueName + ", roleName=" + roleName
				+ ", department=" + department + "]";
	}

}
