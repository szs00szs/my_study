package cc.hansam.java.net.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月21日下午5:39:45
 */
public class HttpTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://192.168.1.124:1532/simple/shi");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"),1024);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
