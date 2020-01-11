package com.yinen.java.interfaceWithMapper.mapper;

import com.yinen.java.interfaceWithMapper.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-10 10:45
 */
public interface LogMapper {
    List<Log> selAll();
    List<Log> selByAccInAccout(@Param("accin")String accin,@Param("accout")String accout);
}
