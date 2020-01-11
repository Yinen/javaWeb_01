package com.yinen.java.bank.service;

import com.yinen.java.bank.pojo.PageInfo;

import java.io.IOException;


public interface LogService  {
	/**
	 * 分页显示
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize, int pageNumber) throws IOException;
}
