package basic.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		File src = new File("C:\\Windows\\explorer.exe");
		File dest = new File("D:\\Temp\\my_exp.exe");
		
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
		
		int c;
		
		while((c = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write((char)c);
		}
		System.out.println("복사 완료!!!");
		
		bufferedOutputStream.close();
		bufferedInputStream.close();
	}

}
