package pathtest;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathTestCase1 {

	public static void main(String[] args) {
		  FileSystem fs = FileSystems.getDefault();
		  Path p = fs.getPath("C:/JavaProgramming/NIO2/DemoFile.txt");
		  System.out.println("Default Directory [" + p + "]"); 
	}//end method main

}//end class PathTestCase1
