package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
 

public class UDP_Server {

	public static void main(String[] args) {
		try {
			DatagramSocket soc = new DatagramSocket(9999); // UDP 소캣생성
			byte [] date = new byte[3000]; // 전송받은 데이터를 지정할 배열 선언
			
			
			//전송받을 packet 객체생성
			DatagramPacket dp = new DatagramPacket(date, date.length);
			System.out.println("데이터 수신 준비 완료");
			
			while(true) {
				soc.receive(dp); // 데이터 수신하기
				System.out.println(" 송신 IP : "+dp.getAddress()); // 데이터 송신 확인
				String msg = new String(dp.getData(),"UTF-8");
				System.out.println("보낸 내용 : "+msg);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
