package com.zizaitianyuan.put;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutputBuffer {

	public static void main(String[] args) {
		UserTimeTool.getInstance().start();
		copy1();
		UserTimeTool.getInstance().stop();
	}

	public static void copy1() {
		Path path1 = Paths.get("./src/main/java/com/zizaitianyuan/put/Input.java");
		Path path2 = Paths.get("./src/main/java/com/zizaitianyuan/put/Inputcopy.java");

		try (InputStream buff1 = new BufferedInputStream(new FileInputStream(path1.toFile()));
				OutputStream buff2 = new BufferedOutputStream(new FileOutputStream(path2.toFile()))) {
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = buff1.read(bytes)) != -1) {
				System.out.println(len);
				buff2.write(bytes, 0, len);   // 如果不设定len，将会造成空位，复制文件将会有错误
				System.out.println(len);
			}
			;
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
