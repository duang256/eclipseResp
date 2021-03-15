package cn.wit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;


import cn.wit.pojo.Flower;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
       
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) {
	Context ctx=null;
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	try {
		ctx = new InitialContext();
		DataSource ds=(DataSource) ctx.lookup("java:comp/env/test");
		//返回的是数据库连接对象，之后像JDBC基本操作一样进行处理
		conn=  ds.getConnection();
		//创建sql命令
		String sql="select *from flower";
		//创建sql命令对象
		ps=conn.prepareStatement(sql);
		//占位符赋值
		//执行sql命令
		rs=ps.executeQuery();
		while(rs.next()){
			Flower flower=new Flower(rs.getInt("id"),rs.getString("name"),
					rs.getDouble("price"),rs.getString("production"));
			System.out.println(flower);
		}
	
		
	} catch (NamingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	//关闭资源
	
	
}

}
