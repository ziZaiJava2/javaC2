package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class Input {
	public static void main(String[] args) {
		// printSelf();
		printSelf3();
	}

	public static void printSelf() {
		InputStream input = null;
		try {
			input = new FileInputStream(Paths.get("./src/main/java/io/Input.java").toFile());
			byte[] bytes = new byte[1];

			int len = 0;
			while ((len = input.read(bytes)) > 0) {
				System.out.print(new String(bytes, 0, len));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception ingore) {

				}
			}
		}

	}

	public static void printSelf2() {
		try (InputStream input = new FileInputStream(Paths.get("./src/main/java/io/Input.java").toFile());) {
			byte[] bytes = new byte[1];
			int len = 0;
			while ((len = input.read(bytes)) > 0) {
				System.out.print(new String(bytes, 0, len));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printSelf3() {
		//可以自动关闭，对input Stream包装，以提供更高级的功能
		try (InputStream input = new FileInputStream(Paths.get("./src/main/java/io/Input.java").toFile());
				Reader reader = new InputStreamReader(input, Charset.defaultCharset());//这里转换编码时会显示乱码
				BufferedReader bf = new BufferedReader(reader);)
		{
			String line;
			while((line = bf.readLine()) !=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
