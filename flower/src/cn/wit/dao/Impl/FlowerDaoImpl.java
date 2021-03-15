package cn.wit.dao.Impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wit.dao.FlowerDao;
import cn.wit.pojo.Flower;
public class FlowerDaoImpl implements FlowerDao{

	@Override
	public List<Flower> selAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			//���������
			Class.forName("com.mysql.jdbc.Driver");
			//�������Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","wityy");
			//����sql����
			String sql="select *from flower";
			//ռλ����ֵ
			//����sql�������
			ps=conn.prepareStatement(sql);
			//ִ��sql����
			rs= ps.executeQuery();
			//�ر���Դ
			List<Flower> list=new ArrayList<>();
			while(rs.next()){
				Flower flower=new Flower();
				flower.setId(rs.getInt("id"));
				flower.setName(rs.getString("name"));
				flower.setPrice(rs.getFloat("price"));
				flower.setProduction(rs.getString("production"));
				list.add(flower);
				//���������Ƿ�����ݿ��õ�
				System.out.println(flower);
			}
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conn!=null){
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return null;
		
	}

	@Override
	public int insert(Flower flower) {
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		try {
			//���������
			Class.forName("com.mysql.jdbc.Driver");
			//�������Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","wityy");
			//����sql����
			String sql="insert into flower values(default,?,?,?)";
			//����sql�������
			ps=conn.prepareStatement(sql);
			//ռλ����ֵ
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProduction());
			
			//ִ��sql����
			int i= ps.executeUpdate();
			//�ر���Դ
			
			return i;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conn!=null){
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return 0;
		
	}

}
