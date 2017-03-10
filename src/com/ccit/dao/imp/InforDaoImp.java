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
		 * 增加工作信息
		 * @param info 要增加的工作信息对象
		 * @return	增加成功返回true否则返回false
		 */
		public boolean addInfo(Information info) {
			String sql="insert into info(userId,startTime,endTime,content,dayTime,isChecked) values('"+info.getUserId()+"','"+info.getStartTime()+"','"+info.getEndTime()+"','"+info.getContent()+"','"+info.getDateTime()+"','"+info.getIsChecked()+"')";
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * 通过id来删除工作信息
		 * @param id	要删除的工作信息id
		 * @return	删除成功返回true否则返回false
		 */
		public boolean deleteInfo(int id) {
			String sql="delete * from info where ="+id;
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * 通过用户id来删除一条工作信息
		 * @param userId	要删除工作信息的用户id
		 * @return	删除成功返回true否则返回false
		 */
		public boolean deleteInfoByUserId(int userId) {
			String sql="delete * from info where ="+userId;
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * 修改当前用户工作信息
		 * @param info	要修改的用户工作信息
		 * @return	修改成功返回true否则返回false
		 */
		public boolean updateInfo(Information info) {
			String sql="update info(userId,startTime,endTime,content,dayTime,isChecked) values('"+info.getUserId()+"','"+info.getStartTime()+"','"+info.getEndTime()+"','"+info.getContent()+"','"+info.getDateTime()+"','"+info.getIsChecked()+"')";
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * 通过id来审核当前工作安排信息
		 * @param id 要审核的信息id
		 * @return	审核成功返回true否则返回false
		 */
		public boolean checkInfo(int id) {
			String sql="update info set inChecked = 1 where id ="+id;
			DBMImp di=new DBMImp();
			return di.ConData(sql);
		}
		
		/**
		 * 判断当日是否有工作安排信息
		 * @param date		要判断工作安排信息的日期数
		 * @param userId 	要获得当前用户的工作安排信息
		 * @return	如果当天有工作安排返回true否则返回false
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
				System.out.println("工作安排信息出错");
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 通过id获取用户信息
		 * @param id	要获取的用户信息的id
		 * @return	用户信息Info对象
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
				System.out.println("id获取information出错");
				e.printStackTrace();
			}
			return infor;
		}
		
		/**
		 * 通过用户id来获取用户信息
		 * @param userId	要获取用户信息的用户id
		 * @return	用户信息Info对象
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
				System.out.println("userid获取information出错");
				e.printStackTrace();
			}
			return infor;
		}
		
		/**
		 * 获取某一用户的工作信息，并完成分页
		 * @param userId	要获取信息的用户id
		 * @param pageNo	当前显示内容的页码
		 * @param pageSize	每页显示的数据条数
		 * @return 分页集合对象
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
				System.out.println("userid获取information出错");
				e.printStackTrace();
			}
			return new PageDiv(pageNo, pageSize, totalNo, list);
		}
		
		/**
		 * 获取某一用户在某一天的工作信息，并完成分页
		 * @param userId	要获取信息的用户id
		 * @param pageNo	当前显示内容的页码
		 * @param pageSize	每页显示信息的条数
		 * @param day		要获取工作信息的日期
		 * @return	PageDiv<Info>集合对象
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
				System.out.println("userid获取information出错");
				e.printStackTrace();
			}
			return new PageDiv(pageNo, pageSize, totalNo, list);
			
		}
		
		/**
		 * 获取到所有的工作信息
		 * @return	用户信息的集合对象
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






