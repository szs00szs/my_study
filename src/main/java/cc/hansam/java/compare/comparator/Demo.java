package cc.hansam.java.compare.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年8月25日下午6:15:05
 */
public class Demo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(10);
		list.add(9);
		list.add(9);

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
//				return o1 - o2;
				return o2 - o1;
			}
		});
		
		
		System.out.println(list);

	}

}
