/**
* <p>
* @Title: EquipmentTypeMapper.java
* <p>
* @Package com.oceansoft.mapper
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-29 ����10:52:20
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.EquipmentType;

/**
 * @Description: �豸�������ݲ�ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 ����10:52:20
 */
public interface EquipmentTypeMapper {

	/**
	 * Description: �豸�����������ѯ
	 *         
	 * @create time ����11:53:43
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<EquipmentType> getEquipmentList(Map<String, Object> params);

	/**
	 * Description: ��ѯ���������ļ�¼��
	 *         
	 * @create time ����11:53:47
	 *
	 * @param equipmentType
	 * @return       
	 *
	 */
	public int getEquipmentListTotal(EquipmentType equipmentType);

	/**
	 * Description: ɾ��ָ���豸����
	 *         
	 * @create time ����2:58:31
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipmentType(int id);

	/**
	 * Description: ���ݱ�ż����豸����
	 *         
	 * @create time ����4:55:30
	 *
	 * @param id
	 * @return       
	 *
	 */
	public EquipmentType getEquipmentTypeById(int id);

	/**
	 * Description: �޸��豸����
	 *         
	 * @create time ����5:54:00
	 *
	 * @param equipmentType       
	 *
	 */
	public void updateEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: ����豸����
	 *         
	 * @create time ����5:55:28
	 *
	 * @param equipmentType       
	 *
	 */
	public void saveEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: �������е��豸����
	 *         
	 * @create time ����2:09:45
	 *
	 * @return       
	 *
	 */
	public List<EquipmentType> getAllEquipmentType();

}
