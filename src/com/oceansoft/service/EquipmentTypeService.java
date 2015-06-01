/**
* <p>
* @Title: EquipmentTypeService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-29 ����10:51:13
* <p>
*/
package com.oceansoft.service;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.EquipmentType;

/**
 * @Description: �豸����ҵ���ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 ����10:51:13
 */
public interface EquipmentTypeService {

	/**
	 * Description: �豸�����������ѯ
	 *         
	 * @create time ����10:59:16
	 *
	 * @param page
	 * @param equipmentType
	 * @return       
	 *
	 */
	public Map<String, Object> equipmentList(String page, EquipmentType equipmentType);

	/**
	 * Description: ɾ���豸����
	 *         
	 * @create time ����2:56:58
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipmentType(int id);

	/**
	 * Description: ���ݱ�ż����豸����
	 *         
	 * @create time ����4:52:38
	 *
	 * @param parseInt
	 * @return       
	 *
	 */
	public EquipmentType getEquipmentTypeById(int parseInt);

	/**
	 * Description: �޸��豸����
	 *         
	 * @create time ����5:31:47
	 *
	 * @param equipmentType       
	 *
	 */
	public void updateEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: ����豸����
	 *         
	 * @create time ����5:31:50
	 *
	 * @param equipmentType       
	 *
	 */
	public void saveEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: �������е��豸����
	 *         
	 * @create time ����2:08:26
	 *
	 * @return       
	 *
	 */
	public List<EquipmentType> getAllEquipmentType();

}
