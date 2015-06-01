/**
* <p>
* @Title: Equipment.java
* <p>
* @Package com.oceansoft.domain
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午3:02:02
* <p>
*/
package com.oceansoft.domain;

/**
 * @Description: 设备实体类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午3:02:02
 */
public class Equipment {

	private EquipmentType equipmentType; // 设备类型
	private Integer id;
	private String name;
	private String no; // 设备编号
	private String remark; // 备注
	private String state; // 状态 1 正常 2 维修 3 报废

	/**
	 * @return the equipmentType
	 */
	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param equipmentType the equipmentType to set
	 */
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", no=" + no + ", equipmentType=" + equipmentType + ", state=" + state
				+ ", remark=" + remark + "]";
	}

}
