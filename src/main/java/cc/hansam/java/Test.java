package cc.hansam.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author 时帅帅 945210972@qq.com
 * @date 2017年3月3日 下午3:08:54
 */
public class Test {

	/**
	 * 
	 * @param args
	 * @author shishuaishuai
	 * @date 2017年3月3日 下午3:09:05
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("name","hansam");
		map.put("age","23");
		map.put("sex","male");
		
		Set<Entry<String, String>> set = map.entrySet();
		
		for (Entry<String, String> entry : set) {
			entry.setValue("jjjj");
		}
		
		System.out.println(map);

	}

}
