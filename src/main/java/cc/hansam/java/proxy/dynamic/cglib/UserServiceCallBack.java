package cc.hansam.java.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB是一个功能强大的，高性能、高质量的代码生成库，用于在运行期扩展Java类和实现Java接口
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年8月9日上午11:06:50
 */
public class UserServiceCallBack implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("start by cglib");
		proxy.invokeSuper(obj, args);
		System.out.println("end by cglib");
		return null;
	}

}
