package io;

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
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class OutPut {
	
	public static void main(String[] args) {
		//true在后面累加

//		try(OutputStream os = new FileOutputStream(new File("./text.log"),true);
//				Writer writer = new OutputStreamWriter(os);
//				BufferedWriter bf = new BufferedWriter(writer);
//				) {
//			os.write("nihao".getBytes());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try (InputStream input = new FileInputStream(Paths.get("./src/main/java/io/OutPut.java").toFile());
				Reader reader = new InputStreamReader(input, Charset.defaultCharset());
				BufferedReader bf = new BufferedReader(reader);)
		{
			String line;
			while((line = bf.readLine()) !=null){
				try(OutputStream os = new FileOutputStream(new File("./output.log"),true);
					Writer writer = new BufferedWriter(new OutputStreamWriter(os));
					BufferedWriter bw = new BufferedWriter(writer);
					){
					writer.write(line+"\n");
				}
				catch(Exception e){
					
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void printSelf(){
//		try (InputStream input = new FileInputStream(Paths.get("./src/main/java/io/OutPut.java").toFile());
//				Reader reader = new InputStreamReader(input, Charset.defaultCharset());
//				BufferedReader bf = new BufferedReader(reader);)
//		{
//			String line;
//			while((line = bf.readLine()) !=null){
//				try(OutputStream os = new FileOutputStream(new File("./output.log"),true);
//					Writer writer = new OutputStreamWriter(os);
//					BufferedWriter bw = new BufferedWriter(writer);
//					){
//					os.write(line.getBytes());
//				}
//				catch(Exception e){
//					
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		}
}
