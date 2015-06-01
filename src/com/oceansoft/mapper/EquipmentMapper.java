/**
* <p>
* @Title: EquipmentMapper.java
* <p>
* @Package com.oceansoft.mapper
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-30 ����2:25:49
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Equipment;
import com.oceansoft.domain.EquipmentType;

/**
 * @Description: �豸�������ݲ�ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-30 ����2:25:49
 */
public interface EquipmentMapper {

	/**
	 * Description: ��ȡ��Ӧ�豸�����µ��豸��Ŀ
	 *         
	 * @create time ����2:50:54
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int getEquipementTotalWithTypeId(int id);

	/**
	 * Description: �ɹ������������ѯ
	 *         
	 * @create time ����12:02:05
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<EquipmentType> getEquipmentList(Map<String, Object> params);

	/**
	 * Description: ���������ļ�¼��
	 *         
	 * @create time ����12:02:11
	 *
	 * @param equipment
	 * @return       
	 *
	 */
	public int getEquipmentTotal(Equipment equipment);

	/**
	 * Description: ɾ���豸
	 *         
	 * @create time ����1:29:42
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipment(int id);

	/**
	 * Description: ���ݱ�ż��زɹ��豸
	 *         
	 * @create time ����1:46:07
	 *
	 * @param parseInt
	 * @return       
	 *
	 */
	public Equipment getEquipmentById(int parseInt);

	/**
	 * Description: �޸��豸
	 *         
	 * @create time ����3:01:06
	 *
	 * @param equipment       
	 *
	 */
	public void update(Equipment equipment);

	/**
	 * Description: ����豸
	 *         
	 * @create time ����3:01:09
	 *
	 * @param equipment       
	 *
	 */
	public void save(Equipment equipment);
	
}
