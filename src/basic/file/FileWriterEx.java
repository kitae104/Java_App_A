package basic.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterEx {

	public static void main(String[] args) {
		InputStreamReader reader = new InputStreamReader(System.in);
		FileWriter writer = null;
		try {
			writer = new FileWriter("D:/Temp/my.txt");
			int c;
			while((c = reader.read()) != -1 ) {				
				writer.write(c);
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null || reader != null) {
					reader.close();
					writer.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
