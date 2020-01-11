package com.yinen.java.bank.controller;

import com.yinen.java.bank.pojo.Account;
import com.yinen.java.bank.service.AccountService;
import com.yinen.java.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-09 12:17
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    private AccountService accService = new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Account accOut = new Account();
        accOut.setAccNo(req.getParameter("accOutAccNo"));
        accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
        accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
        Account accIn =new Account();
        accIn.setAccNo(req.getParameter("accInAccNo"));
        accIn.setName(req.getParameter("accInName"));
        int index = accService.transfer(accIn, accOut);
        if(index==AccountService.SUCCESS){
            resp.sendRedirect("/javaWeb_01/transfer/show");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("code", index);
            resp.sendRedirect("/bank/error/error.jsp");
        }

    }
}
