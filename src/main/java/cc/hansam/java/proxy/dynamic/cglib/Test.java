package cc.hansam.java.proxy.dynamic.cglib;

import cc.hansam.java.proxy.dynamic.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/** 
 * @author hansam 945210972@qq.com
 * @date   2017年8月9日上午11:16:21 
 */
public class Test {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallback(new UserServiceCallBack());
		UserServiceImpl proxy = (UserServiceImpl)enhancer.create();
		
		proxy.addUser();
	}

}
