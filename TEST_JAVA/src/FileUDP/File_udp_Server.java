package FileUDP;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class File_udp_Server {

		public static void main(String[] args) throws IOException {
			DatagramSocket soc = new DatagramSocket(9999);//9999번 포트를 열어 둔다.
			System.out.println("전송받을 준비 완료!");
			File file = null;
			DataOutputStream dos = null;
			
			while (true) { //무한 루프를 돌면서 도착하는 데이터를 입력받는다.
				DatagramPacket dp = new DatagramPacket(new byte[1024], 1024); //1024byte를 사용한다.
				soc.receive(dp); //패킷을 전송받는다.
				String str = new String(dp.getData()).trim(); //전송 받은 데이터의 내용을 String 객체의 형태로 변환
				if (str.equalsIgnoreCase("start")) { //(대소문자 구분하지 않고) 도착한 데이터 내용이 'start'와 같은지
					System.out.println("전송되고 있음!");
					file = new File("A2.txt"); // 'start'라는 글자가 도착할때 A2.txt라는 파일을 생성한다.
					dos = new DataOutputStream(new BufferedOutputStream( //생성된 파일에 대한 출력 개체
												new FileOutputStream(file)));
				}
				else if (str.equalsIgnoreCase("end")) { //마찬가지로 도착내용이 'end'와 같은지
					System.out.println("전송 완료!");
					dos.close();
					break;
				}
				else if (file != null) {
					dos.write(str.getBytes(), 0, str.getBytes().length);
				}
			}
		}
	}