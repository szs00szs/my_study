package cc.hansam.java.net.socket.tcp.multi;

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
 * @date 2017年4月11日 下午3:49:36
 */
class ServerThread extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				String str = in.readLine();
				if (str.equals("end")) {
					break;
				}
				System.out.println("request: " + str);
				out.println(str);
			}
		} catch (Exception e) {
			System.err.println("IO Exception");
		} finally {
			System.out.println("closing...");
			try {
				out.close();
				in.close();
				socket.close();
			} catch (Exception e2) {
				System.err.println("close fail");
			}
		}
	}
}

public class MultiServer {
	static final int PORT = 8081;

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("server started");
		try {
			while (true) {
				Socket socket = s.accept();
				try {
					new ServerThread(socket);
				} catch (Exception e) {
					socket.close();
				}
			}
		} finally {
			s.close();
		}
	}

}
