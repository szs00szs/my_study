package cc.hansam.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月27日下午3:18:22
 */
public class Main {
    public static void main(String[] args) {
        for (int j = 0; j < 100; j++){
            double random = Math.random();
            System.out.println(random);
            double i = random * 9 + 1;
            System.out.println(i);
            System.out.println((int)(i * 100000));
            System.out.println("=======================");
        }
    }
}