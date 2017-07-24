package cc.hansam.java.net.ws.test.server;

import javax.xml.ws.Endpoint;

/** 
 * @author hansam 945210972@qq.com
 * @date   2017年6月21日下午7:02:43 
 */
public class ServicePublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/hello", new MyServiceImpl());
	}

}
