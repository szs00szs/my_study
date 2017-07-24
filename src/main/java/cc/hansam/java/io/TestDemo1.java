package cc.hansam.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;



/**
 * @author 时帅帅 945210972@qq.com
 * @version 创建时间：2016年10月9日 上午10:22:58
 */
public class TestDemo1 {

	@Test
	public void read() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("d:/myFile.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}


	@Test
	public void write() throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter("d:/myFile.txt", true));
		br.write("hello winter\n");
		br.close();
	}
	
	public static boolean deleteDir(File dir){
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir,children[i]));
				if (!success) {
					return false;
				}
			}
		}
		System.out.println("the directory is deleted");
		return dir.delete();
	}

}
