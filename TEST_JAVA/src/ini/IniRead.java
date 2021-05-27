package ini;


import java.io.FileInputStream;
import java.io.IOException;


public class IniRead {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("C:\\Users\\kimkyuho\\eclipse-workspace\\Basic\\src\\ini\\config.ini");
		int c;
		while((c = fin.read()) != -1) {  // 파일의 끝을 만나면 -1 return
		    System.out.print((char)c); 
		}
	}
}
