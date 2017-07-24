package cc.hansam.java.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;


/**
 * @author hansam 945210972@qq.com
 * @date 2017年6月30日下午2:59:29
 */
public class Main {
	
	@Test
	public void read(){
		URL resource = ClassLoader.getSystemResource("shishuaishuai.txt");
		System.out.println(resource.getPath());
		System.out.println("jjj");
	}
	
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("shishuaishuai.txt", "rw");
		FileChannel channel = file.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(80);

		int i = channel.read(buffer);
		while (i != -1) {
			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
			buffer.clear(); // make buffer ready for writing
			i = channel.read(buffer);
		}
		file.close();

	}

}
