package cc.hansam.java.net.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * ContentType("application/json")
 * @author hansam 945210972@qq.com
 * @date 2017年7月13日下午6:41:35
 */
@SuppressWarnings("deprecation")
public class HttpPostJSONRequest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/springweb/restcontroller/v5.0/new/odb";
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity("{\"age\":22,\"id\":1,\"name\":\"时帅帅\"}",HTTP.UTF_8);
		 

		entity.setContentType("application/json;charset=utf-8");
		httpPost.setEntity(entity);

		@SuppressWarnings("resource")
		HttpResponse response = new DefaultHttpClient().execute(httpPost);
		
		

		System.out.println(response.getStatusLine());
		if (response.getStatusLine().getStatusCode() == 200) {

			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		}

	}
}
