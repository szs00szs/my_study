package cc.hansam.java.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler是代理实例的调用处理程序实现的接口
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年8月9日上午10:54:58
 */
public class MyHandler implements InvocationHandler {
	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start by jdk");
		method.invoke(target, args);
		System.out.println("end by jdk");
		return null;
	}

}
