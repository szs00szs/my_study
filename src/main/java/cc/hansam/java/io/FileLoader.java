package cc.hansam.java.io;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * resource文件的相对路径,在加载相对路径的文件时， 使用ClassLoader.getSystemResource("");获取相对路径
 * 
 * @author hansam 945210972@qq.com
 * @date 2017年8月1日下午4:11:43
 */
public class FileLoader {

	public static void main(String[] args) throws URISyntaxException {
		URL url = ClassLoader.getSystemResource("log4j.properties");
		File file = new File(url.toURI());

		System.out.println(file.exists());
	}

}
