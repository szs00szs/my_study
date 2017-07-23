package cc.hansam.java.net.ws.server;

import javax.jws.WebService;

/** 
 * @author hansam 945210972@qq.com
 * @date   2017年6月21日下午7:11:07 
 */
@WebService
public interface MyService {
	public String say(String name);
}
