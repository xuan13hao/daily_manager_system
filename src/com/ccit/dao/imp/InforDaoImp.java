package com.ccit.dao.imp;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ccit.bean.Information;
import com.ccit.dao.InforDao;
import com.ccit.dbcon.DBManager;
import com.ccit.dbpool.DBMImp;
import com.ccit.pagediv.PageDiv;

/**
 * @author admin
 *
 */
public class InforDaoImp implements InforDao{
		DBManager DBM=null;
	
		/**
		 * ���ӹ�����Ϣ
		 * @param info Ҫ���ӵĹ�����Ϣ����
		 * @return	���ӳɹ�����true���򷵻�false
		 */
		public boolean addInfo(Information info) {
			String sql="insert into info(userId,startTime,endTime,content,dayTime,isChecked) values('"+info.getUserId()+"','"+info.getStartTime()+"','"+info.getEndTime()+"','"+info.getContent()+"','"+info.getDateTime()+"','"+info.getIsChecked()+"')";
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * ͨ��id��ɾ��������Ϣ
		 * @param id	Ҫɾ���Ĺ�����Ϣid
		 * @return	ɾ���ɹ�����true���򷵻�false
		 */
		public boolean deleteInfo(int id) {
			String sql="delete * from info where ="+id;
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * ͨ���û�id��ɾ��һ��������Ϣ
		 * @param userId	Ҫɾ��������Ϣ���û�id
		 * @return	ɾ���ɹ�����true���򷵻�false
		 */
		public boolean deleteInfoByUserId(int userId) {
			String sql="delete * from info where ="+userId;
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * �޸ĵ�ǰ�û�������Ϣ
		 * @param info	Ҫ�޸ĵ��û�������Ϣ
		 * @return	�޸ĳɹ�����true���򷵻�false
		 */
		public boolean updateInfo(Information info) {
			String sql="update info(userId,startTime,endTime,content,dayTime,isChecked) values('"+info.getUserId()+"','"+info.getStartTime()+"','"+info.getEndTime()+"','"+info.getContent()+"','"+info.getDateTime()+"','"+info.getIsChecked()+"')";
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * ͨ��id����˵�ǰ����������Ϣ
		 * @param id Ҫ��˵���Ϣid
		 * @return	��˳ɹ�����true���򷵻�false
		 */
		public boolean checkInfo(int id) {
			String sql="update info set inChecked = 1 where id ="+id;
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * �жϵ����Ƿ��й���������Ϣ
		 * @param date		Ҫ�жϹ���������Ϣ��������
		 * @param userId 	Ҫ��õ�ǰ�û��Ĺ���������Ϣ
		 * @return	��������й������ŷ���true���򷵻�false
		 */
		public boolean hasInfo(Date date, int userId) {
			String sql="select * from info where date='"+date+"' and userId="+userId+"";
			DBM=new DBManager();
			try {
				if(DBM.ReadDB(sql).next());
				{
					return true;
				}
			} catch (SQLException e) {
				System.out.println("����������Ϣ����");
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * ͨ��id��ȡ�û���Ϣ
		 * @param id	Ҫ��ȡ���û���Ϣ��id
		 * @return	�û���ϢInfo����
		 */
		public Information getInfo(int id) {
			Information infor=null;
			String sql="select * from info where id ="+id;
			DBM=new DBManager();
			ResultSet rs=DBM.ReadDB(sql);
			try {
				while(rs.next())
				{
					 infor=new Information();
					infor.setUserId(rs.getInt("userId"));
					infor.setStartTime(rs.getString("startTime"));
					infor.setEndTime(rs.getString("endTime"));
					infor.setContent(rs.getString("content"));
					infor.setDateTime(rs.getDate("dateTime"));
					infor.setIsChecked(rs.getInt("isChecked"));
				}
			} catch (SQLException e) {
				System.out.println("id��ȡinformation����");
				e.printStackTrace();
			}
			return infor;
		}
		
		/**
		 * ͨ���û�id����ȡ�û���Ϣ
		 * @param userId	Ҫ��ȡ�û���Ϣ���û�id
		 * @return	�û���ϢInfo����
		 */
		public Information getInfoByUserId(int userId) {
			Information infor=null;
			String sql="select * from info where userId="+userId;
			DBM=new DBManager();
			ResultSet rs=DBM.ReadDB(sql);
			try {
				while(rs.next())
				{
					infor=new Information();
					infor.setStartTime(rs.getString("startTime"));
					infor.setEndTime(rs.getString("endTime"));
					infor.setContent(rs.getString("content"));
					infor.setDateTime(rs.getDate("dateTime"));
					infor.setIsChecked(rs.getInt("isChecked"));
				}
			} catch (SQLException e) {
				System.out.println("userid��ȡinformation����");
				e.printStackTrace();
			}
			return infor;
		}
		
		/**
		 * ��ȡĳһ�û��Ĺ�����Ϣ������ɷ�ҳ
		 * @param userId	Ҫ��ȡ��Ϣ���û�id
		 * @param pageNo	��ǰ��ʾ���ݵ�ҳ��
		 * @param pageSize	ÿҳ��ʾ����������
		 * @return ��ҳ���϶���
		 */
		public PageDiv getInfoByPd(int userId, int pageNo, int pageSize) {
			Information infor=null;
			List<Information> list =new ArrayList<Information>();
			PageDiv pd=new PageDiv();
			String sql="select * from info limit "+pageNo+","+pageSize+" and where userId ="+userId;
			DBM=new DBManager();
			String sqlcount="selec count(*) from user";
			int totalNo=DBM.getUserNum(sqlcount);
			ResultSet rs=DBM.ReadDB(sql);
			try {
				while(rs.next())
				{
					infor=new Information();
					infor.setStartTime(rs.getString("startTime"));
					infor.setEndTime(rs.getString("endTime"));
					infor.setContent(rs.getString("content"));
					infor.setDateTime(rs.getDate("dateTime"));
					infor.setIsChecked(rs.getInt("isChecked"));
					list.add(infor);
				}
			} catch (SQLException e) {
				System.out.println("userid��ȡinformation����");
				e.printStackTrace();
			}
			return new PageDiv(pageNo, pageSize, totalNo, list);
		}
		
		/**
		 * ��ȡĳһ�û���ĳһ��Ĺ�����Ϣ������ɷ�ҳ
		 * @param userId	Ҫ��ȡ��Ϣ���û�id
		 * @param pageNo	��ǰ��ʾ���ݵ�ҳ��
		 * @param pageSize	ÿҳ��ʾ��Ϣ������
		 * @param day		Ҫ��ȡ������Ϣ������
		 * @return	PageDiv<Info>���϶���
		 */
		public PageDiv getInfoByPdByDay(int userId, int pageNo, int pageSize, Date dayTime) {
			Information infor=null;
			List<Information> list =new ArrayList<Information>();
			PageDiv pd=new PageDiv();
			String sql="select * from info limit "+pageNo+","+pageSize+" and where userId ="+userId+" and dayTime="+dayTime;
			DBM=new DBManager();
			String sqlcount="selec count(*) from user";
			int totalNo=DBM.getUserNum(sqlcount);
			ResultSet rs=DBM.ReadDB(sql);
			try {
				while(rs.next())
				{
					infor=new Information();
					infor.setStartTime(rs.getString("startTime"));
					infor.setEndTime(rs.getString("endTime"));
					infor.setContent(rs.getString("content"));
					infor.setDateTime(rs.getDate("dateTime"));
					infor.setIsChecked(rs.getInt("isChecked"));
					list.add(infor);
				}
			} catch (SQLException e) {
				System.out.println("userid��ȡinformation����");
				e.printStackTrace();
			}
			return new PageDiv(pageNo, pageSize, totalNo, list);
			
		}
		
		/**
		 * ��ȡ�����еĹ�����Ϣ
		 * @return	�û���Ϣ�ļ��϶���
		 */
		public List<Information> getAllInfo() {
			Information infor=null;
			List<Information> list =new ArrayList<Information>();
			String sql="select * from info";
			DBM=new DBManager();
			ResultSet rs=DBM.ReadDB(sql);
			try {
				while(rs.next())
				{
					infor=new Information();
					infor.setUserId(rs.getInt("id"));
					infor.setUserId(rs.getInt("userId"));
					infor.setStartTime(rs.getString("startTime"));
					infor.setEndTime(rs.getString("endTime"));
					infor.setContent(rs.getString("content"));
					infor.setDateTime(rs.getDate("dateTime"));
					infor.setIsChecked(rs.getInt("isChecked"));
					list.add(infor);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	}






