package com.hansam.java.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 时帅帅 945210972@qq.com
 * @version 创建时间：2017年1月11日 下午2:20:30
 */
public class Test {
	public static void main(String[] args) {

		System.out.println("Current Locale: " + Locale.getDefault());
		ResourceBundle mybundle = ResourceBundle.getBundle("name");

		System.out.println("我的名字：" + mybundle.getString("my_name"));

		Locale.setDefault(new Locale("en", "US"));
		System.out.println("Current Locale: " + Locale.getDefault());
		mybundle = ResourceBundle.getBundle("name");
		System.out.println("my name is:" + mybundle.getString("my_name"));

	}
}
