package com.yinen.java.flower.controller;

import com.yinen.java.flower.pojo.Flower;
import com.yinen.java.flower.service.FlowerService;
import com.yinen.java.flower.service.impl.FlowerServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private FlowerService flowerService =new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Flower> list = flowerService.show();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
