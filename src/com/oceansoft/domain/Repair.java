/**
* <p>
* @Title: Repair.java
* <p>
* @Package com.oceansoft.domain
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午3:05:23
* <p>
*/
package com.oceansoft.domain;

import java.util.Date;

/**
 * @Description: 维修表实体类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午3:05:23
 */
public class Repair {

	private Equipment equipment;
	private String finishState; // 1未处理 2 处理完毕
	private Date finishTime; // 完成时间
	private Integer id;
	private String repairman; // 维修人
	private Date repairTime; // 维修时间
	private String state; // 最终设备状态 1 维修成功 2设备报废
	private String userman; // 报修人

	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @return the finishState
	 */
	public String getFinishState() {
		return finishState;
	}

	/**
	 * @return the finishTime
	 */
	public Date getFinishTime() {
		return finishTime;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the repairman
	 */
	public String getRepairman() {
		return repairman;
	}

	/**
	 * @return the repairTime
	 */
	public Date getRepairTime() {
		return repairTime;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the userman
	 */
	public String getUserman() {
		return userman;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @param finishState the finishState to set
	 */
	public void setFinishState(String finishState) {
		this.finishState = finishState;
	}

	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param repairman the repairman to set
	 */
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}

	/**
	 * @param repairTime the repairTime to set
	 */
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param userman the userman to set
	 */
	public void setUserman(String userman) {
		this.userman = userman;
	}

	@Override
	public String toString() {
		return "Repair [id=" + id + ", equipment=" + equipment + ", userman=" + userman + ", repairman=" + repairman + ", repairTime="
				+ repairTime + ", finishTime=" + finishTime + ", state=" + state + ", finishState=" + finishState + "]";
	}

}
