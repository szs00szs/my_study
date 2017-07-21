package cc.hansam.java.net.socket.tcp.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 时帅帅 945210972@qq.com
 * @date 2017年4月11日 上午11:08:02
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8081);
		System.out.println("get connect:" + socket);

		InputStream inputStream = socket.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
		inputStream.close();

		socket.close();
	}

}
