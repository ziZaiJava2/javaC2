package com.zizaitianyuan.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSelf3();
	}
//"函数" printSelf()比较低级 
	public static void printSelf() {
		//Java 1.7 省代码
		try(InputStream input =new FileInputStream(Paths.get("./src/main/java/com/zizaitianyuan/io/input.java").toFile())) {
			byte[] bytes = new byte[1024];
			//byte[] bytes = new byte[1];//中文会乱码
			int len = 0;
			while ((len = input.read(bytes)) > 0) {
				System.out.print(new String(bytes, 0, len));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		}
	
	
	
	public static void printSelf2() {
		InputStream input = null;
		try {
			input = new FileInputStream(Paths.get("./src/main/java/com/zizaitianyuan/io/input.java").toFile());
			byte[] bytes = new byte[1024];
			//byte[] bytes = new byte[1];//中文会乱码
			int len = 0;
			while ((len = input.read(bytes)) > 0) {
				System.out.print(new String(bytes, 0, len));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();

				} catch (Exception ignore) {
					// TODO: handle exception
				}
			}
		}

	}


	
	public static void printSelf3() {
		try (
			InputStream input=new FileInputStream(Paths.get("./src/main/java/com/zizaitianyuan/io/input.java").toFile());
			Reader reader=new InputStreamReader(input,Charset.defaultCharset());
			BufferedReader bf=new BufferedReader(reader);	
		){
			String line;
			while((line=bf.readLine())!=null){
				System.out.println(line);
			}
								
		
		
		}	catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
}
