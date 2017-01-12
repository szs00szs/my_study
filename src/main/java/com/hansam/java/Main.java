package com.hansam.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 时帅帅 945210972@qq.com
 * @version 创建时间：2016年10月28日 下午5:15:49
 */

public class Main {

	public static void main(String[] args) {

	        Set<String> test1 = new HashSet<>();
	        test1.add("a");

	        Set<String> test2 = test1;

	        boolean b = test1.containsAll(test2);
	        System.out.println(b);


		
	}
}
