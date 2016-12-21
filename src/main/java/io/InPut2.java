package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class InPut2 {

	public static void main(String[] args) {

		print2();
	}

	public static void print() {
		try (InputStream input = new FileInputStream(Paths.get(".\\src\\main\\java\\io\\OutPut.java").toFile());
				OutputStream os = new FileOutputStream(new File("./text2.log"), true);) {

			byte[] bytes = new byte[1];
			int a = 0;
			while ((a = input.read(bytes)) > 0) {
				os.write((new String(bytes, 0, a)).getBytes());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print2() {
		try (InputStream input = new FileInputStream(Paths.get(".\\src\\main\\java\\io\\OutPut.java").toFile());
				Reader reader = new InputStreamReader(input, Charset.defaultCharset());
				OutputStream os = new FileOutputStream(new File("./text2.log"), true);
				Writer writer = new OutputStreamWriter(os);) {

			char[] chars = new char[100];
			while ((reader.read(chars))!=-1) {
				writer.write(chars);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print3() {
		try (InputStream input = new FileInputStream(Paths.get(".\\src\\main\\java\\io\\OutPut.java").toFile());
				Reader reader = new InputStreamReader(input, Charset.defaultCharset());
				BufferedReader bf = new BufferedReader(reader);
				OutputStream os = new FileOutputStream(new File("./text2.log"), true);
				Writer writer = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(writer);) {

			String a;
			String b = new String();
			while ((a = bf.readLine()) != null) {
				b = b + a + "\n";
			}
			bw.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
