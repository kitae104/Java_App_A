package basic.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
     
	public static void main(String[] args) throws IOException   {		
		FileReader fileReader = new FileReader("D:/Temp/test.txt"); 
		
		int i; 
		while((i = fileReader.read()) != -1) {
			System.out.print((char)i);
		}

	}

}
