package com.yinen.java.flower.service;

import com.yinen.java.flower.pojo.Flower;

import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-04 10:58
 */
public interface FlowerService {
    /**
     * 显示所有花卉信息
     * @return
     */
    List<Flower> show();

    /**
     * 新增
     * @param flower
     * @return
     */
    int add(Flower flower);
}
