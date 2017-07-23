package cc.hansam.java.net.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cc.hansam.java.net.ws.server.MyService;

/** 
 * @author hansam 945210972@qq.com
 * @date   2017年6月21日下午7:03:56 
 */
public class HelloCli {
	
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/hello?wsdl");
		QName qName = new QName("http://ser.ws.hansam.cc/", "MyServiceImplService");
		Service service = Service.create(url,qName);
		
		MyService myService = service.getPort(MyService.class);
		System.out.println(myService.say("ertyuio"));
	}

}
