package com.yinen.java.bank.controller;

import com.yinen.java.bank.service.LogService;
import com.yinen.java.bank.service.impl.LogServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/transfer/show")
public class ShowServlet extends HttpServlet {
	private LogService logService = new LogServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize = 2;
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		String pageNumberStr = req.getParameter("pageNumber");
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		req.setAttribute("pageinfo", logService.showPage(pageSize, pageNumber));
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
	}
}
