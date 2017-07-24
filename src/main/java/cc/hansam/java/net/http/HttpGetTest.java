package cc.hansam.java.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年7月24日上午11:44:16
 */
public class HttpGetTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://192.168.1.124:1532/simple/shi");
		HttpResponse response = httpclient.execute(httpget);
		
		// 响应成功
		if (response.getStatusLine().getStatusCode() == 200) {
			HttpEntity entity = response.getEntity();

			StringBuilder sb = new StringBuilder();
			String line;

			if (entity != null) {
				InputStream instream = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(instream, HTTP.UTF_8), 1024);
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			}
			String result = sb.toString();
			System.out.println(result);

			Map map = JSONObject.parseObject(result,Map.class);
			
			System.out.println(map);
			System.out.println(map.get(("data")));
		}
	}
}
