package cc.hansam.java.classLoader;

/**
 * @author: shuaishuai.shi
 * @date: 2019/12/16 17:47
 */
public class Parent {

    public static void parentStaticMethod() {
        System.out.println("父静态方法");
    }

    {
        System.out.println("父非静态代码块");
    }

    static {
        System.out.println("父静态代码块");
    }

    public Parent() {
        System.out.println("父构造方法");
    }

    public void parentMethod() {
        System.out.println("父普通方法");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("父类销毁");
    }
}
