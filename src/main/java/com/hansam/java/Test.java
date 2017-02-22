package com.hansam.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author 时帅帅 945210972@qq.com
 * @version 创建时间：2017年2月19日 上午10:44:10
 */
public class Test {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(4,2,5,6,1));
		TreeSet<Integer> set = new TreeSet<>(list);
		System.out.println(set);
		
	}
}
