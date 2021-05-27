package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;


public class UDP_Client {

	public static void main(String[] args) {
		//키보드 입력을 받기 위한 변수
		Scanner scanner = new Scanner(System.in);
		System.out.println("보낼 메세지 입력 : ");
		String msg = scanner.next();
		
		try {
			DatagramSocket soc = new DatagramSocket(); // 전송가능한 소켓 생성
			InetAddress ia = InetAddress.getByName("127.0.0.1"); // 수신받을 곳의 주소 생성
			//전송할 데이터 생성
			DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,ia,9999);
			
			//데이터 전송
			soc.send(dp);
			soc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}