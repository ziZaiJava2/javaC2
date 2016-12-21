package com.zizaitianyuan.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (OutputStream os = new FileOutputStream(new File("./test.log"),true);
				Writer writer=new OutputStreamWriter(os);
				BufferedWriter bw=new BufferedWriter(writer);
	)
				{
			bw.write("testsssssssssss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
