package cc.hansam.java.compare.compareble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年8月25日下午6:40:05
 */
public class Test {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		Student stu = new Student();
		stu.setId(10);
		stu.setName("shi");
		list.add(stu);
		
		Student stu2 = new Student();
		stu2.setId(9);
		stu2.setName("shuai");
		list.add(stu2);
		
		Student stu3 = new Student();
		stu3.setId(1);
		stu3.setName("we");
		list.add(stu3);
		
		
		Collections.sort(list);
		
		System.out.println(list);
	}

}
