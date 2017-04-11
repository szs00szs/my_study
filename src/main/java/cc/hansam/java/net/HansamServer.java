package cc.hansam.java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 时帅帅 945210972@qq.com
 * @date 2017年4月11日 下午2:56:29
 */
public class HansamServer {

	public static final int PORT = 8081;

	public static void main(String[] args) throws IOException {

		ServerSocket s = new ServerSocket(PORT);
		System.out.println("started: " + s);

		Socket socket = s.accept();
		System.out.println("connection  accepted: " + socket);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

		while (true) {
			String str = in.readLine();
			if (str.equals("end")) {
				break;
			}
			System.out.println("request: " + str);
			out.println(str);
		}

		System.out.println("closing...");
		out.close();
		in.close();
		socket.close();
		s.close();
	}
}
