package com.yinen.java.page.controller;

import com.yinen.java.page.pojo.PageInfo;
import com.yinen.java.page.service.PeopleService;
import com.yinen.java.page.service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-07 16:01
 */
@WebServlet("/page")
public class ShowPageServlet extends HttpServlet {
    private PeopleService peopleService = new PeopleServiceImpl();
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String pageSizeStr=req.getParameter("pageSize");
        int pageSize=2;
        if(pageSizeStr!=null&&!pageSizeStr.equals("")){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        String pageNumberStr = req.getParameter("pageNumber");
        int pageNumber = 1;
        if(pageNumberStr!=null&&!pageNumberStr.equals("")){
            pageNumber = Integer.parseInt(pageNumberStr);
        }

        PageInfo pi=peopleService.showPage(pageSize, pageNumber);
        req.setAttribute("PageInfo",pi);
        req.getRequestDispatcher("showPage.jsp").forward(req, res);
    }
}
