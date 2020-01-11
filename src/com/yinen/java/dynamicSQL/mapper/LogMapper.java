package com.yinen.java.dynamicSQL.mapper;

import java.util.List;

import com.yinen.java.dynamicSQL.pojo.Log;
import org.apache.ibatis.annotations.Param;


public interface LogMapper {
	List<Log> selByAccinAccout(@Param("accout") String accout, @Param("accin") String accin);
	
	
	int upd(Log log);
	
	
	List<Log> selByLog(Log log);
	
	
	List<Log> selIn(List<Integer> list);
	
	
	int ins(List<Integer> list);
}
