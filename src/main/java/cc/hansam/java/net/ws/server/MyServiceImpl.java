package cc.hansam.java.net.ws.server;

import javax.jws.WebService;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年6月21日下午7:00:30
 */

@WebService(endpointInterface="cc.hansam.ws.ser.MyService")
public class MyServiceImpl implements MyService {

	public String say(String name) {
		return "hello " + name;
	}

}
