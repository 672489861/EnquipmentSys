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
* @date   2015-6-1 ����10:02:59
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Repair;

/**
 * @Description: �豸ά�����ݲ�ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-6-1 ����10:02:59
 */
public interface RepairMapper {

	/**
	 * Description: �����豸
	 *         
	 * @create time ����10:41:39
	 *
	 * @param id
	 * @param userName
	 * @return       
	 *
	 */
	public int repairEquipment(int id, String userName);

	/**
	 * Description: ά���豸�����������ѯ
	 *         
	 * @create time ����12:51:17
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<Repair> getRepairList(Map<String, Object> params);

	/**
	 * Description: ��ȡ���������ļ�¼��
	 *         
	 * @create time ����12:51:49
	 *
	 * @param repair
	 * @return       
	 *
	 */
	public int getRepairListTotal(Repair repair);

	/**
	 * Description: �����豸״̬
	 *         
	 * @create time ����2:33:37
	 *
	 * @param params
	 * @return       
	 *
	 */
	public int updateState(Map<String,Object> params);

}
