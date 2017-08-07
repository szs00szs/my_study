package cc.hansam.test;

import java.io.IOException;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月27日下午3:18:22
 */
public class App {
	public static void main(String[] args) {
		
		try {
			System.in.read();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
