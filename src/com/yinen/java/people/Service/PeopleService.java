package com.yinen.java.people.Service;

import com.yinen.java.people.pojo.People;

import java.io.IOException;
import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-05 9:59
 */
public interface PeopleService {
    /*
        方法功能：显示全部人员信息
        参数：无
        描述：返回值为一个List
    */
    List<People> show()throws IOException;
}
