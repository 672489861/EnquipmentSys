/**
* <p>
* @Title: EquipmentType.java
* <p>
* @Package com.oceansoft.domain
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午2:59:30
* <p>
*/
package com.oceansoft.domain;

/**
 * @Description: 设备类型实体类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午2:59:30
 */
public class EquipmentType {

	private Integer id;

	private String remark; // 备注名称

	private String typeName; // 类型名称
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
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
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

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "EquipmentType [id=" + id + ", typeName=" + typeName + ", remark=" + remark + "]";
	}

}
