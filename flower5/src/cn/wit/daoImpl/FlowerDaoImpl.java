package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wit.dao.FlowerDao;
import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;

public class FlowerDaoImpl implements FlowerDao{
	
	@Override
	public int count() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//类加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","wityy");
			//创建sql命名
			String sql="select count(*) from flower";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//执行sql命令
			rs=ps.executeQuery();
			int  i=0;
			if(rs.next()) {
			i=rs.getInt(1);
			}
			return i;
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
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
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}

	@Override
	public List<Flower> selByPage(PageInfo pi) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//类加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","wityy");
			//创建sql命令
			String sql="select *from flower limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setObject(1,pi.getStartNumber());
			ps.setObject(2, pi.getPageSize());
			rs=ps.executeQuery();
			List<Flower>list=new ArrayList<Flower>();
			while(rs.next()){
				Flower flower=new Flower();
				flower.setId(rs.getInt("id"));
				flower.setName(rs.getString("name"));
				flower.setPrice(rs.getDouble("price"));
				flower.setProduction(rs.getString("production"));
				list.add(flower);
			}
			
			return list;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return null;
		
	}

}
