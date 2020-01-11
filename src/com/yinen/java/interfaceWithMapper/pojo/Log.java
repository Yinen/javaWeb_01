package com.yinen.java.interfaceWithMapper.pojo;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-09 9:39
 */
public class Log {
    private int id;
    private String accIn;
    private String accOut;
    private double money;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccIn() {
        return accIn;
    }
    public void setAccIn(String accIn) {
        this.accIn = accIn;
    }
    public String getAccOut() {
        return accOut;
    }
    public void setAccOut(String accOut) {
        this.accOut = accOut;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
}
