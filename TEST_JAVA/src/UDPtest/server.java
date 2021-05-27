package UDPtest;

import java.net.*;
import java.io.*;

public class server {
	public static void main(String args[]) {
		int port = 9999;
		// 소켓 서버생성
		DatagramSocket serverDatagramSocket = null;
		try {
			serverDatagramSocket = new DatagramSocket(port);
			System.out.println("Created UDP Echo Server on port" + 9999);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		try {
			byte buffer[] = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			String input;
			while (true) {
				// 데이터그램 패킷 수신 대기 accept()와 비슷
				serverDatagramSocket.receive(datagramPacket);
				input = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
				System.out.println("from server: " + input);
				// 수신된 패킷을 클라이언트에게 다시 보냅니다.
				serverDatagramSocket.send(datagramPacket);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
