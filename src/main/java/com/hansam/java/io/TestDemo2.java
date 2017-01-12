package com.hansam.java.io;

import java.io.File;

/**
 * @author 时帅帅 945210972@qq.com
 * @version 创建时间：2016年10月9日 上午10:22:58
 */
public class TestDemo2 {

	public static void main(String[] args) {
		File file = new File("d:/a");
		findlist(file);
	}
	
	public static void findlist(File dir) {
		if (dir.isDirectory()) {
			String[] list = dir.list();
			System.out.println(dir+"\n\t");
			for (String string : list) {
				findlist(new File(dir,string));
			}
		}
	}

}
