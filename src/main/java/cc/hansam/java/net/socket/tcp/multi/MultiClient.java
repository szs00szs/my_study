package cc.hansam.java.net.socket.tcp.multi;

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
 * @date 2017年4月11日 下午3:49:45
 */

class ClientThread extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private static int counter = 0;
	private int id = counter++;
	private static int threadcount = 0;

	public ClientThread(InetAddress address) {
		System.out.println("Making client " + id);
		threadcount++;

		try {
			socket = new Socket(address, MultiServer.PORT);
		} catch (Exception e) {
			System.err.println("socket failed");
		}

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			start();
		} catch (Exception e) {
			try {
				socket.close();
			} catch (IOException e1) {
				System.err.println("socket not closed");
			}
		}

	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				out.println("client " + id + ": " + i);
				String str = in.readLine();
				System.out.println(str);
			}
			out.println("end");
		} catch (Exception e) {
			System.err.println("IO Exception");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println("socket not closed");
			}
			threadcount--;
		}
	}

	public static int threadCount() {
		return threadcount;
	}
}

public class MultiClient {
	static final int MAX_THREADS = 30;

	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress address = InetAddress.getByName(null);
		while (true) {
			if (ClientThread.threadCount() < MAX_THREADS) {
				new ClientThread(address);
				Thread.sleep(100);
			}
		}
	}
}
