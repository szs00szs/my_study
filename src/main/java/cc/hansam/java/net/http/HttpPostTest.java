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
 * @author hansam 945210972@qq.com
 * @date 2017年7月13日下午6:41:35
 */
@SuppressWarnings("deprecation")
public class HttpPostTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
//		String url = "http://10.80.184.203:8886/PMServerHttpDataInterface/";
		String url = "http://www.hansam.cc";
		HttpPost httpPost = new HttpPost(url);

		// List<NameValuePair> parms = new ArrayList<>();
		//
		// parms.add(new BasicNameValuePair("Type", "1"));
		// parms.add(new BasicNameValuePair("UserName", "admin"));
		// parms.add(new BasicNameValuePair("Password", "admin"));

		StringEntity entity = new StringEntity("{\"Type\":1,\"UserName\":\"admin\",\"Password\":\"admin\"}",HTTP.UTF_8);

		httpPost.setEntity(entity);

		@SuppressWarnings("resource")
		HttpResponse response = new DefaultHttpClient().execute(httpPost);
		
		

		if (response.getStatusLine().getStatusCode() == 200) {

			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		}

	}
}
