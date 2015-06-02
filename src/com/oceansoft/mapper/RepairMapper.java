/**
* <p>
* @Title: RepairMapper.java
* <p>
* @Package com.oceansoft.mapper
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-6-1 下午10:02:59
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Repair;

/**
 * @Description: 设备维修数据层接口
 *
 * @author zjw
 * 
 *      @create time  2015-6-1 下午10:02:59
 */
public interface RepairMapper {

	/**
	 * Description: 报修设备
	 *         
	 * @create time 下午10:41:39
	 *
	 * @param id
	 * @param userName
	 * @return       
	 *
	 */
	public int repairEquipment(int id, String userName);

	/**
	 * Description: 维修设备管理主界面查询
	 *         
	 * @create time 下午12:51:17
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<Repair> getRepairList(Map<String, Object> params);

	/**
	 * Description: 获取符合条件的记录数
	 *         
	 * @create time 下午12:51:49
	 *
	 * @param repair
	 * @return       
	 *
	 */
	public int getRepairListTotal(Repair repair);

	/**
	 * Description: 更新设备状态
	 *         
	 * @create time 下午2:33:37
	 *
	 * @param params
	 * @return       
	 *
	 */
	public int updateState(Map<String,Object> params);

}
