package com.yinen.java.flower.controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-04 18:32
 *
 * 因为现在数据库池由Tomcat管理，所以要部署到Tomcat才能测试
 */

@WebServlet("/pool")
public class DemoC3p0Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Context cxt = new InitialContext();
            //"java:comp/env/"这个是固定的
            DataSource ds = (DataSource) cxt.lookup("java:comp/env/test");
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from flower");
            ResultSet rs = ps.executeQuery();
            res.setContentType("text/html;charset=utf-8");  //解决乱码
            PrintWriter out = res.getWriter();
            while(rs.next()){
                out.print(rs.getInt(1)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+"<br/>");
            }
            out.flush();
            out.close();
            rs.close();     //转成空闲状态
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
