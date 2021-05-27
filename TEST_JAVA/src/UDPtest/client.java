package UDPtest;

import java.net.*;
import java.io.*;

public class client {
	public static class UDPEchoReader extends Thread {
		public UDPEchoReader(DatagramSocket socket) {
			datagramSocket = socket;
			active = true;
		}

		public void run()
	 {
	 byte[] buffer = new byte[1024];
	 DatagramPacket incoming = new DatagramPacket(buffer,
	 buffer.length);
	 String receivedString;
	 while(active)
	 {
	 try
	 {
	 // 데이터그램 패킷 수신대기
	 datagramSocket.receive(incoming);
	 receivedString = new String(incoming.getData(),
	 0, incoming.getLength());
	 System.out.println("from server:"+receivedString);
	 }
	 catch(IOException e)
	 {
	 System.out.println(e);
	 active = false;
	 }
	 }
	 }

		public boolean active;
		public DatagramSocket datagramSocket;
	}

	public static void main(String[] args) {
		InetAddress address = null;
		int port = 9999;
		DatagramSocket datagramSocket = null;
		BufferedReader keyboardReader = null;
		// 데이터그램 소켓 생성
		try {
			address = InetAddress.getByName("127.0.0.1");
			datagramSocket = new DatagramSocket();
			keyboardReader = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		// 스레드를 시작.
		UDPEchoReader reader = new UDPEchoReader(datagramSocket);
		reader.setDaemon(true);
		reader.start();
		System.out.println("Ready to send your messages");
		try {
			String input;
			while (true) {
				// 입력값을 읽어온다.
				input = keyboardReader.readLine();
				// 패킷을 서버로 전송하는것
				DatagramPacket datagramPacket = new DatagramPacket(input.getBytes(), input.length(), address, 9999);
				datagramSocket.send(datagramPacket);
			}
		} catch (IOException e) {
			System.out.println(e); // 예외값
		}
	}
}
