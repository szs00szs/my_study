package cc.hansam.java.proxy.statics;

/**
 * 代理类
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年8月9日上午10:34:42
 */
public class BusinessAgent implements Sell {

	private Vendor vendor;

	public BusinessAgent(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public void sell() {
		// 进行功能增强
		System.out.println("before..");
		vendor.sell();
		System.out.println("after..");

	}

	@Override
	public void ad() {
		System.out.println("before..");
		vendor.ad();
		System.out.println("after..");
	}

}
