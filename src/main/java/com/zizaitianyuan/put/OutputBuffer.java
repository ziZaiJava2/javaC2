package com.zizaitianyuan.put;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class OutputBuffer {

	public static void main(String[] args) {
		UserTimeTool.getInstance().start();
		copy1();
		UserTimeTool.getInstance().stop();
	}
	
	public static void copy1(){
		InputStream input = null;	
		OutputStream output = null;
		BufferedInputStream buff1= null;
		BufferedOutputStream buff2= null;
	try {
		input = new FileInputStream(Paths.get("./src/main/java/com/zizaitianyuan/sp/Input.java").toFile());
		output = new FileOutputStream(Paths.get("./src/main/java/com/zizaitianyuan/sp/Inputcopy.java").toFile());
		
		byte[] bytes  = new byte[1024];
		
		buff1=new BufferedInputStream(input);
		buff2=new BufferedOutputStream(output);
		
		int len = 0;
		while((len = buff1.read(bytes)) != -1){
			System.out.println(len);
			buff2.write(bytes, 0, len);    //如果不设定len，将会造成空位，复制文件将会有错误
			System.out.println(len);
		};
	} catch (IOException e) {
		
		e.printStackTrace();
	}finally{
		
		try {
			if(buff1 != null){
				buff1.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		try {
			if(input != null){
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(buff2 != null){
				buff2.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		try {
			if(output != null){
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	}
}
