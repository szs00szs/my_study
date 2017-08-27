package cc.hansam.java.reflect;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年8月9日上午11:41:31
 */
public class Demo {

	public static void main(String[] args) {
		Demo demo = new Demo();

		System.out.println(demo.getClass());
		System.out.println(demo.getClass().getName());
		System.out.println(demo.getClass().getPackage());
		
		System.out.println("=============================");
		Class<?> clazz = String.class;
		System.out.println(clazz);
		Class<?> superclass = clazz.getSuperclass();
		System.out.println(superclass);
	}

}
