package com.yinen.java.test;

import java.util.HashMap;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-02 19:55
 */
public class DebugTest {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        HashMap<String,String > map=new HashMap<String,String >();
        map.put("name","tom");
        map.put("age","12");
        map.put("school","FZU");
        map.put("major","computer");

        String age=map.get("age");
        System.out.println("age="+age);

        map.remove("major");
        System.out.println(map);
    }
}
