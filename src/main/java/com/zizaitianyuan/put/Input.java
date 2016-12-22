package com.zizaitianyuan.put;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class Input {

	public static void main(String[] args) {
		
		println();
	}
	
	public static void print(){
		InputStream input = null;
		
		try {
			input = new FileInputStream(Paths.get("./src/main/java/com/zizaitianyuan/sp/User.java").toFile());
			
			byte[] bytes  = new byte[1024];
			int len = 0;
			while((len = input.read(bytes, 0, bytes.length)) != -1){
				System.out.println(new String(bytes, 0 ,len));
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
		}
	}
	
	public static void println(){
			InputStream input = null;		
			BufferedInputStream buff= null;
		try {
			input = new FileInputStream(Paths.get("./src/main/java/com/zizaitianyuan/sp/User.java").toFile());
			
			byte[] bytes  = new byte[1024];
			buff=new BufferedInputStream(input);
			int len = 0;
		
			while((len = buff.read(bytes, 0, bytes.length)) != -1){
				System.out.println(new String(bytes, 0 ,len));
			};
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			
			try {
				if(buff != null){
					buff.close();
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
				
			
		}
	}

}
