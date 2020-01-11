package com.yinen.java.log4j;


import org.apache.log4j.Logger;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-05 13:44
 */
public class Test {
    /*
        ma快捷键
        方法功能：测试log4j
        ①首先要导包
        ②然后创建  log4j.properties于src文件夹下  修改配置文件
        ③最后使用如下输出日志
    */
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(Test.class);
        logger.debug("这是一个debug信息");
        logger.info("这是一个Info信息");
        //try快捷键
        try {
            int in=5/0;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        System.out.println("结束");
    }
}
