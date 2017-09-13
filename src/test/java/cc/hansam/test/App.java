package cc.hansam.test;

import java.lang.reflect.Method;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月27日下午3:18:22
 */
public class App {
	public static void main(String[] args) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			try {
				Class<?> forName = Class.forName(JDriver);
				Method[] methods = forName.getMethods();
				for (Method method : methods) {
					System.out.println(method);
				}
				System.out.println(forName.getMethods());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	}
}