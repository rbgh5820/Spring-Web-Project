package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_EchoServer {

	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = null;
		DatagramPacket receivePacket,sendPacket = null; //데이터 수신 송신
		final int portNumber = 9999; // 클라이언트와 서버의 포트번호가 일치해야됨

		try {
			datagramSocket = new DatagramSocket(9999); // 데이어터그램 패킷을 받기위한 소캣 생성
			System.out.println("================");
			System.out.println(" Server 준비 ");
			System.out.println("================");
		//서버 유지를 위해 while문으로 루프를 돌린다.
		while(true) {
			byte[]buf=new byte[1024]; // 버퍼 생성
			receivePacket = new DatagramPacket(buf,buf.length); //패킷을 생성한다.
			datagramSocket.receive(receivePacket); // Data 수신받을때까지 기다린다.
			// 수신된 Data를 출력한다. byte형태로 받았기에 String으로 변형해준다.
			String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("클라이언트에게 보낸 메세지 : "+msg);
			// 서버에서 클라이언트로 전송
			sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getData().length, receivePacket.getAddress(), receivePacket.getPort());
			datagramSocket.send(sendPacket);
		}
		}catch(SocketException e) {
			e.printStackTrace();
			System.out.println("datagramSocket = new DatagramSocket(otherPort) 실패");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("datagramSocket.receive(datagramPacket) 실패");
		}finally {
			datagramSocket.close();
			System.out.println("UDP_EchoServer 종료");
		}
	}

}
