package com.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class AboutPath {

	public static void main(String[] args) throws IOException {
		
		Path path= Paths.get("./src/main");
		
		Files.walkFileTree(path,new Visitor());
	}
	
}

class Visitor extends SimpleFileVisitor<Path>{

	public FileVisitResult visitFile(Path file,BasicFileAttributes attre) {
		
		if(file.toString().endsWith(".java")){
			
			System.out.println(file.toAbsolutePath());
			
		}
		
		return FileVisitResult.CONTINUE;
	}
}
