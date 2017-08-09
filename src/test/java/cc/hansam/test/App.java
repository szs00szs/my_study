package cc.hansam.test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月27日下午3:18:22
 */
public class App {
	public static void main(String[] args) {

		try {
			System.in.read();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
	
}

class Animal {
	public static String name = "shishuai";

	public void say() {
		System.out.println("this is animal...");
	}
}

class Dog extends Animal {
	public void say() {
		System.out.println("this is dog...");
	}
	

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Animal a = new Animal();

		String name = Animal.class.getName();
		System.out.println(name);

		Field field = Animal.class.getField("name");
		System.out.println(field.get("name"));

		Method method = Animal.class.getMethod("say", null);
		Object invoke = method.invoke(a, null);

	}
}
