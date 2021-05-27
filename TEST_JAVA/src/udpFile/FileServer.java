package udpFile;

import java.io.*;
import java.net.*;


public class FileServer {

	public static void main(String[] args) {
        // 문자열로 이루어진 파일을 전송받는 프로그랭
         
        // 전송받을 UDP 소켓을 생성
        try {
            DatagramSocket socket =new DatagramSocket(9875);
            System.out.println("수신 준비 완료.......");
             
            // 전송받은 내용을 저장할 함수
            File file =null;
            // 데이터를 전송받을 Stream 변수
            DataOutputStream dos =null;
             
            while(true){
                // 전송받을 데이터 패킷 생성
                DatagramPacket dp =new DatagramPacket(new byte[512], 512);
                // 데이터 전송받기
                socket.receive(dp);
                // 전송받은 데이터 를 문자열료 변환
                String str =new String(dp.getData()).trim();
                // 전송받은 문자열이 strat 라면 받으룬비
                if(str.equals("start")){
                    System.out.println(" 전송 시작  ");
                    // 파일 객체 생성
                    file =new File("c://User//");
                    // 파일 쓰기 객체 새엉
                    dos =new DataOutputStream(new BufferedOutputStream(
                            new FileOutputStream(file)));
                    }
                    //end가 ㅇ면 종료
                    else if(str.equals("end")){
                        System.out.println("전송완료");
                        socket.close();break;
                         
                    }
                    else{
                        // dos에 연결된 파일에 str의 바이ㅌ 배열은 0부터 부ㅜ터 길이많큼 기록
                        dos.write(str.getBytes(),0,str.getBytes().length);
                    }
                     
                }  
                dos.close();
             
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
         
 
    }
 
}

