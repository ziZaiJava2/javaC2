package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Output {
	
	public static void main(String[] args) {
		
		try(	InputStream in = new FileInputStream(new File("F:/github/javaC2/src/main/java/com/io/output.java"));
				
				Reader reader = new InputStreamReader(in);
				
				BufferedReader br = new BufferedReader(reader);
				
				OutputStream os = new FileOutputStream(new File("./testCopy"));
				
				Writer writer = new OutputStreamWriter(os);
				
				BufferedWriter bw = new BufferedWriter(writer);
				
		){
			
			//只采用inputStream输入流与outputStream输出流
			
//			byte b[]=new byte[1024];
//			
//			int len=0;
//			
//			while((len=in.read(b))!=-1){
//				
//				os.write(b,0,len);
//				
//			}
			
			//只采用reader与writer
			
//			char c[] = new char[1024];
//			
//			int len=0;
//			
//			while((len=reader.read(c))!=-1){
//				
//				writer.write(c,0,len);
//				
//			}
			
			//只采用bufferReader和bufferWriter
			
			String str = null;
			
			while((str = br.readLine()) != null){
				
				bw.write(str+"\n");
				
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}
		
	}
}
