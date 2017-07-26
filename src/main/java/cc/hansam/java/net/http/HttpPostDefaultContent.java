package cc.hansam.java.net.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * default ContentType
 * @author hansam 945210972@qq.com
 * @date 2017年7月13日下午6:41:35
 */
@SuppressWarnings("deprecation")
public class HttpPostDefaultContent {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/springweb/restcontroller/v6.0/new/odb";
		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> parms = new ArrayList<>();

		parms.add(new BasicNameValuePair("id", "1"));
		parms.add(new BasicNameValuePair("name", "admin"));
		parms.add(new BasicNameValuePair("age", "22"));

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms, HTTP.UTF_8);

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
