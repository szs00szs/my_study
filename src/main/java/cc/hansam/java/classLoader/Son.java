package cc.hansam.java.classLoader;

/**
 * @author: shuaishuai.shi
 * @date: 2019/12/16 17:50
 */
public class Son extends Parent{
    public static void sonStaticMethod() {
        System.out.println("子静态方法");
    }

    public void sonMethod() {
        System.out.println("子普通方法");
    }

    {
        System.out.println("子非静态代码块");
    }

    static {
        System.out.println("子静态代码块");
    }

    public Son() {
        System.out.println("子构造方法");
    }

    @Override
    public void parentMethod() {
        super.parentMethod();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("子类销毁");
    }
}
