package com.zizaitianyuan.put;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PutStream {
	public static void main(String[] args) {
		UserTimeTool.getInstance().start();
		copy1();
		UserTimeTool.getInstance().stop();
	}

	public static void copy1() {
		Path path1 = Paths.get("./src/main/java/com/zizaitianyuan/put/Input.java");
		Path path2 = Paths.get("./src/main/java/com/zizaitianyuan/put/Inputcopy.java");

		try (InputStream input = new FileInputStream(path1.toFile());
				OutputStream output = new FileOutputStream(path2.toFile())) {
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = input.read(bytes)) != -1) {
				System.out.println(len);
				output.write(bytes, 0, len); // 如果不设定len，将会造成空位，复制文件将会有错误
				System.out.println(len);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
