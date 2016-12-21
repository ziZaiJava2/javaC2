package com.zizaitianyuan.put;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;

public class ReaderPut {
	
	public static void main(String[] args) {
		UserTimeTool.getInstance().start();
		copy1();
		UserTimeTool.getInstance().stop();
	}
	
	public static void copy1(){
		Reader input = null;	
		Writer output = null;
		
	try {
		input = new FileReader(Paths.get("./src/main/java/com/zizaitianyuan/sp/Input.java").toFile());
		output = new FileWriter(Paths.get("./src/main/java/com/zizaitianyuan/sp/Inputcopy.java").toFile());
		
		char[] bytes  = new char[1024];
		
		int len = 0;
		while((len = input.read(bytes)) != -1){
			System.out.println(len);
			output.write(bytes, 0, len);    //如果不设定len，将会造成空位，复制文件将会有错误
			System.out.println(len);
		};
	} catch (IOException e) {
		
		e.printStackTrace();
	}finally{
	
		try {
			if(input != null){
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
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
