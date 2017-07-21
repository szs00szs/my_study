package cc.hansam.java.json;

import java.util.Map;
import com.alibaba.fastjson.JSON;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月17日下午4:59:16
 */
public class JSONTest {


	public static void main(String[] args) {
		Person person = new Person();
		person.setId(1);
		person.setName("shi");
		person.setAge(22);
		person.setSex("male");

		// object to jsonstring
		String jString = JSON.toJSONString(person);
		System.out.println(jString);
		
		// jsonstring parse to map
		Map<String,String> map = (Map<String, String>)JSON.parse(jString);
		System.out.println(map.get("name"));

		
		// jsonstring pare to object
		String str = "{\"age\":22,\"id\":1,\"name\":\"shi\",\"sex\":\"male\",\"dea\":\"male\",\"sasa\":\"male\"}";
		Person p = JSON.parseObject(str, Person.class);
		System.out.println(p);
		
		/**
		 * fastjson 转换key不区分大小写，转换没有明确的对应关系（多对多）
		 */
		
	}

}
