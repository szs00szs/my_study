package cc.hansam.java.net.ws.odb;

/**
 * 通过wsimport生成的客户端代码调用webservice服务
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年7月24日下午3:03:19
 */
public class App {

	public static void main(String[] args) {
		WSServiceImplService service = new WSServiceImplService();

		WSServiceImpl po = service.getWSServiceImplPort();

		String call = po.call("");

		System.out.println(call);
	}

}
