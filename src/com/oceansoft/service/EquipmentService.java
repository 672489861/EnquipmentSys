/**
* <p>
* @Title: EquipmentService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-30 ����2:23:36
* <p>
*/
package com.oceansoft.service;

import java.util.Map;

import com.oceansoft.domain.Equipment;

/**
 * @Description: �豸����ҵ���ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-30 ����2:23:36
 */
public interface EquipmentService {

	/**
	 * Description: ��ѯ��Ӧ�豸�����µ��豸��Ŀ
	 *         
	 * @create time ����2:49:56
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int getEquipmentTotalWithTypeId(int id);

	/**
	 * Description: �ɹ������������ѯ
	 *         
	 * @create time ����12:01:11
	 *
	 * @param page
	 * @param equipment
	 * @return       
	 *
	 */
	public Map<String, Object> equipmentList(String page, Equipment equipment);

	/**
	 * Description: ɾ��ָ���豸
	 *         
	 * @create time ����1:28:58
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipment(int id);

	/**
	 * Description: ����id���زɹ��豸
	 *         
	 * @create time ����1:42:38
	 *
	 * @param id
	 * @return       
	 *
	 */
	public Equipment getEquipmentById(String id);

	/**
	 * Description: �޸��豸
	 *         
	 * @create time ����3:00:16
	 *
	 * @param equipment       
	 *
	 */
	public void update(Equipment equipment);

	/**
	 * Description: ����豸
	 *         
	 * @create time ����3:00:18
	 *
	 * @param equipment       
	 *
	 */
	public void save(Equipment equipment);

}
