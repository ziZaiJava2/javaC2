package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Input {

	public static void main(String[] args) {

		printSelt3();

	}

	// “我是注释”
	public static void printSelt() {

		InputStream input = null;

		try {

			input = new FileInputStream(new File("F:/github/javaC2/src/main/java/com/io/Input.java"));

			byte b[] = new byte[1];

			int len = 0;

			while ((len = input.read(b)) != -1) {

				System.out.println(new String(b, 0, len));

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

	public static void printSelt2() {

		try (InputStream input = new FileInputStream(new File("F:/github/javaC2/src/main/java/com/io/Input.java"))) {

			byte b[] = new byte[1];

			int len = 0;

			while ((len = input.read(b)) != -1) {

				System.out.println(new String(b, 0, len));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void printSelt3() {
		try (InputStream input = new FileInputStream(new File("F:/github/javaC2/src/main/java/com/io/Input.java"));

				Reader reader = new InputStreamReader(input , "UTF-8");

				BufferedReader bf = new BufferedReader(reader);

		) {
			String line;

			while ((line = bf.readLine()) != null) {

				System.out.println(line);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
