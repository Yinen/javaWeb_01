package com.yinen.java.opensessioninview.service.impl;

import com.yinen.java.opensessioninview.mapper.LogMapper;
import com.yinen.java.opensessioninview.pojo.Log;
import com.yinen.java.opensessioninview.service.LogService;
import com.yinen.java.opensessioninview.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;



public class LogServiceImpl implements LogService {

	@Override
	public int ins(Log log) {
		SqlSession session = MyBatisUtil.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.ins(log);
	}

}
