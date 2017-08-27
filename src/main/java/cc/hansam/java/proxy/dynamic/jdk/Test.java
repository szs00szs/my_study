package cc.hansam.java.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

import cc.hansam.java.proxy.dynamic.UserService;
import cc.hansam.java.proxy.dynamic.UserServiceImpl;

/** 
 * @author hansam 945210972@qq.com
 * @date   2017年8月9日上午10:59:03 
 */
public class Test {
	public static void main(String[] args) {
		MyHandler handler = new MyHandler();
		UserService userService = new UserServiceImpl();
		handler.setTarget(userService);

		Class<? extends UserService> clazz = userService.getClass();
		UserService UserServiceProxyInstance = (UserService)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
		
		UserServiceProxyInstance.addUser();
	}

}
