package com.yinen.java.flower.service.impl;

import com.yinen.java.flower.dao.FlowerDao;
import com.yinen.java.flower.dao.impl.FlowerDaoImpl;
import com.yinen.java.flower.pojo.Flower;
import com.yinen.java.flower.service.FlowerService;

import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-04 10:59
 */

public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();
    @Override
    public List<Flower> show() {
        return flowerDao.selAll();
    }
    @Override
    public int add(Flower flower) {
        return flowerDao.insFlower(flower);
    }

}
