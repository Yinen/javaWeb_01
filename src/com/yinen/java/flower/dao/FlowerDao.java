package com.yinen.java.flower.dao;

import com.yinen.java.flower.pojo.Flower;

import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-04 10:18
 */
public interface FlowerDao {
    /**
     * 查询全部
     * @return
     */
    List<Flower> selAll();

    /**
     * 新增
     * @param flower
     * @return
     */
    int insFlower(Flower flower);
}

