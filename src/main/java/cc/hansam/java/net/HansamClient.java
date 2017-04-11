package cc.hansam.java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 时帅帅 945210972@qq.com
 * @date 2017年4月11日 下午3:06:17
 */
public class HansamClient {

	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName(null);
		System.out.println("address: " + address);

		Socket socket = new Socket(address, HansamServer.PORT);
		System.out.println("socket: " + socket);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

		for (int i = 0; i < 10; i++) {
			out.println("hi " + i);
			String str = in.readLine();
			System.out.println(str);
		}
		out.println("end");
		
		System.out.println("closing...");
		out.close();
		in.close();
		socket.close();
	}

}
