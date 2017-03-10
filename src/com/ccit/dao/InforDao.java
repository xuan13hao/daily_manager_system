package com.ccit.dao;

import java.sql.Date;
import java.util.List;
import com.ccit.pagediv.*;
import com.ccit.bean.Information;

public interface InforDao{
	/**
	 * �ó����ж��ڹ�����Ϣ���ܹ����еĲ���
	 * @author XH
	 *
	 */
	public interface InfoDao {
		/**
		 * ���ӹ�����Ϣ
		 * @param info Ҫ���ӵĹ�����Ϣ����
		 * @return	���ӳɹ�����true���򷵻�false
		 */
		public boolean addInfo(Information info);
		
		/**
		 * ͨ��id��ɾ��������Ϣ
		 * @param id	Ҫɾ���Ĺ�����Ϣid
		 * @return	ɾ���ɹ�����true���򷵻�false
		 */
		public boolean deleteInfo(int id);
		
		/**
		 * ͨ���û�id��ɾ��һ��������Ϣ
		 * @param userId	Ҫɾ��������Ϣ���û�id
		 * @return	ɾ���ɹ�����true���򷵻�false
		 */
		public boolean deleteInfoByUserId(int userId);
		
		/**
		 * �޸ĵ�ǰ�û�������Ϣ
		 * @param info	Ҫ�޸ĵ��û�������Ϣ
		 * @return	�޸ĳɹ�����true���򷵻�false
		 */
		public boolean updateInfo(Information info);
		
		/**
		 * ͨ��id����˵�ǰ����������Ϣ
		 * @param id Ҫ��˵���Ϣid
		 * @return	��˳ɹ�����true���򷵻�false
		 */
		public boolean checkInfo(int id);
		
		/**
		 * �жϵ����Ƿ��й���������Ϣ
		 * @param date		Ҫ�жϹ���������Ϣ��������
		 * @param userId 	Ҫ��õ�ǰ�û��Ĺ���������Ϣ
		 * @return	��������й������ŷ���true���򷵻�false
		 */
		public boolean hasInfo(Date date, int userId);
		
		/**
		 * ͨ��id��ȡ�û���Ϣ
		 * @param id	Ҫ��ȡ���û���Ϣ��id
		 * @return	�û���ϢInfo����
		 */
		public Information getInfo(int id);
		
		/**
		 * ͨ���û�id����ȡ�û���Ϣ
		 * @param userId	Ҫ��ȡ�û���Ϣ���û�id
		 * @return	�û���ϢInfo����
		 */
		public Information getInfoByUserId(int userId);
		
		/**
		 * ��ȡĳһ�û��Ĺ�����Ϣ������ɷ�ҳ
		 * @param userId	Ҫ��ȡ��Ϣ���û�id
		 * @param pageNo	��ǰ��ʾ���ݵ�ҳ��
		 * @param pageSize	ÿҳ��ʾ����������
		 * @return ��ҳ���϶���
		 */
		public PageDiv getInfoByPd(int userId, int pageNo, int pageSize);
		
		/**
		 * ��ȡĳһ�û���ĳһ��Ĺ�����Ϣ������ɷ�ҳ
		 * @param userId	Ҫ��ȡ��Ϣ���û�id
		 * @param pageNo	��ǰ��ʾ���ݵ�ҳ��
		 * @param pageSize	ÿҳ��ʾ��Ϣ������
		 * @param day		Ҫ��ȡ������Ϣ������
		 * @return	PageDiv<Info>���϶���
		 */
		public PageDiv getInfoByPdByDay(int userId, int pageNo, int pageSize, Date dayTime);
		
		/**
		 * ��ȡ�����еĹ�����Ϣ
		 * @return	�û���Ϣ�ļ��϶���
		 */
		public List<Information> getAllInfo();
	}


}
