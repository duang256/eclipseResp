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
			//类加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","wityy");
			//创建sql命令
			String sql="select *from flower";
			//占位符赋值
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//执行sql命令
			rs= ps.executeQuery();
			//关闭资源
			List<Flower> list=new ArrayList<>();
			while(rs.next()){
				Flower flower=new Flower();
				flower.setId(rs.getInt("id"));
				flower.setName(rs.getString("name"));
				flower.setPrice(rs.getFloat("price"));
				flower.setProduction(rs.getString("production"));
				list.add(flower);
				//测试数据是否从数据库拿到
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
			//类加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","wityy");
			//创建sql命令
			String sql="insert into flower values(default,?,?,?)";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//占位符赋值
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProduction());
			
			//执行sql命令
			int i= ps.executeUpdate();
			//关闭资源
			
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
