package cc.hansam.java.net.simple;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 时帅帅 945210972@qq.com
 * @date 2017年4月11日 上午11:07:54
 */
public class Server{

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8081);
		Socket accept = socket.accept();
		System.out.println("accept..");
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(accept.getOutputStream())));
		System.out.println(accept);
		out.write("[response]:[welcome to west world]\n");
		out.write("[response]:[welcome to west world]\n");
		out.write("[response]:[welcome to west world]\n");
		out.write("[response]:[welcome to west world]\n");
		out.write("[response]:[welcome to west world]\n");
		out.close();
		socket.close();
	}

}
