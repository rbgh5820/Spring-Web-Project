package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_EchoClient {

	public static void main(String[] args)  {
		DatagramSocket datagramSocket = null; 
		DatagramPacket receivePacket,sendPacket = null;
		InetAddress inetAddress = null;
		BufferedReader br = null;
		int portNumber = 9999;
		String ipNumber="10.40.10.69";
		
		try {
			// 20~26 IP주소 입력 사항 확인
			if(args.length != 2) {
				System.out.println("Server IP, Port 입력 바랍니다.");
				System.exit(0);
				}else {
				ipNumber = args[0];
				portNumber = Integer.parseInt(args[1]);
				}
				// DataPacket에 들어갈 IP주소가 address형태로 만듬
				inetAddress = InetAddress.getByName("10.40.10.69");
				//Socket 생성
				datagramSocket = new DatagramSocket(); 
				// 서버로 메세지 전송을 위한 입력 스트림 생성
				br = new BufferedReader(new InputStreamReader(System.in)); 
				//서버에게 메세지 전송
				while(true) {
					// 메세지 입력
					String msg="";
					System.out.print("메세지를 입력하세요 : ");
					msg = br.readLine();
					
					//데이터 그램에 정보를 담고 서버에 전송
					sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddress, 9999);
					datagramSocket.send(sendPacket); 
					//클라이언트로 보낸 메시지 받기
					byte[] buffer = new byte[msg.getBytes().length]; // 배열 생성
					receivePacket = new DatagramPacket(buffer,buffer.length); // 수신패킷 생성
					datagramSocket.receive(receivePacket);
					
					String msg2=new String(receivePacket.getData(),0,receivePacket.getData().length);
					System.out.println("Server에서 보낸 메세지 : "+msg2);
				}
				
		}catch(SocketException e) {
			e.printStackTrace();
			System.out.println("inetAddress = InetAddress.getByName(ipNumber) 실패");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("datagramSocket.send(sendPacket) 실패");
		}finally {
			datagramSocket.close();
			System.out.println("UDP 에코 클라이언트 종료");
		}
	}
}