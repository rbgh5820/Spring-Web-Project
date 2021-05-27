package FileUDP;

import java.io.*;
import java.net.*;
import java.util.*;

public class File_udp_Client {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream dis = null;
		
		System.out.print("전송대상 = "); //파일을 전송하려는 곳의 IP 주소를 기재한다.(본인의 아이피 작성)
		String ip = in.readLine(); 
		System.out.print("전송파일 = "); 
		//전송하려는 파일명을 기재한다. 만약 다른경로에 있는 파일을 전송하려면 전체 경로를 적어야한다
		String filename = in.readLine();
		
		File file = new File(filename); //파일 객체 생성
		if (!file.exists()) { // 파일이 존재하는지 그 유무를 먼저 판단.
			System.err.println("파일이 존재하지 않습니다");
			System.exit(-1);//파일이 없으면 송신프로그램 종료
		}
		DatagramSocket ds = new DatagramSocket(); //파일을 전송할 소켓 객체를 생성 
		InetAddress ia = InetAddress.getByName(ip); //전송받을 곳의 IP주소를 InetAddress 객체로 생성
		//'start' 라는 글자를 먼저 전송하여 파일의 전송 시작을 목적지 컴퓨터에게 알려준다. 이것이 전송되면 목적지 컴퓨터에서는 
		// 임의의 이름으로 파일을 생성하고 입력받을 준비를 한다.
		String str = "start";
		DatagramPacket dp = new DatagramPacket(
				str.getBytes(), str.getBytes().length, ia, 9999);
		ds.send(dp);
		
		//전송단위 1024byte로 설정했다.
		dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		byte[] by = new byte[1024]; // 실무에서는 주로 256 byte, 512 byte 단위로 보냄
		
		while(true) {
			int xx = dis.read(by, 0, by.length);
			if (xx == -1)break;
			dp = new DatagramPacket(by, xx, ia, 9999);
			ds.send(dp);
		}
		
		//end라는 글자를 전송하여 파일 전송을 알린다.
		str = "end";
		dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 9999);
		ds.send(dp);
		ds.close();
		System.out.print("전송완료~!!");
	}
}