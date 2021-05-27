package FileTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Fileclient {

	public static void main(String[] args) throws  IOException {
		Socket socket = new Socket("localhost",9999);
		System.out.println("접속 완료");
		
		Scanner sc = new Scanner(System.in);
		
		//데이터를 통해 소켓 스트림을 얻는다
		InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        
        OutputStream out = socket.getOutputStream(); // 출력 스트림 얻기
        DataOutputStream dos = new DataOutputStream(out);
        
        System.out.println("받고 싶은 파일의 이름을 입력하세요");
        String fileNameMsg = sc.nextLine(); // 보낼 내용을 읽고 서버로 보내는 코드
        dos.writeUTF(fileNameMsg);
        System.out.println("서버에 파일 요청을 했습니다.");
        System.out.println("서버에서 파일 데이터를 받아옵니다.");
        FileOutputStream fos = new FileOutputStream(fileNameMsg);
        
        while(true){
            int data=dis.read();
            if(data == -1) break;
            fos.write(data);
        }
        System.out.println("전송이 완료 되었습니다.");
        dos.close(); 
        dis.close();
        out.close();
        in.close();
        socket.close();
	}

}
