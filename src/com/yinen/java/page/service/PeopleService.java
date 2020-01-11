package com.yinen.java.page.service;

import com.yinen.java.page.pojo.PageInfo;

import java.io.IOException;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-07 15:40
 */
public interface PeopleService {
    /*
        方法功能：分页显示
        @param pageSize
	    @param pageNumber
	    @return
    */
    PageInfo showPage(int pageSize,int pageNum)throws IOException;
}
