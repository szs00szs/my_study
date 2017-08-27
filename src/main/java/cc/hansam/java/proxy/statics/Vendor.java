package cc.hansam.java.proxy.statics;

/**
 * 委托类
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年8月9日上午10:32:28
 */
public class Vendor implements Sell {

	@Override
	public void sell() {
		System.out.println("In sell method");

	}

	@Override
	public void ad() {
		System.out.println("ad method");
	}

}
