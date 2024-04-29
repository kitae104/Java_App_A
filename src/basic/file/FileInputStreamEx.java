package basic.file;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {
     
	public static void main(String[] args) throws IOException {		
		FileInputStream fileInputStream = new FileInputStream("C:/Windows/system.ini");
		System.out.println("파일 읽기 성공");
		int i; 
		while((i = fileInputStream.read()) != -1) {
			System.out.print((char)i);
		}

	}

}
