package udpFile;

import java.io.*;
import java.net.*;
import java.util.*;
 


public class FileClient {

	 public static void main(String[] args) {
	        // 파일이름을 입력받기 위한 변수
	        Scanner scanner =new Scanner(System.in);
	        System.out.println("전송할 파일이름 : ");
	         
	        // 전송할 곳의 주소를 저장할 변수
	        String ip ="127.0.0.1";
	        // 파일명을 저장할 변수
	        String filename =null;
	        // 파일의 내용을 읽을 변수
	        DataInputStream dis =null;
	 
	        // 파일 이름 입력 받기
	        filename = scanner.next();
	         
	        // 입력 받은 이름으로 file 객체 생성
	        File file =new File(filename);
	         
	        // 파일이 없다면 프로그램 종료
	        if(file.exists() ==false){
	            System.out.println("파일이 존재하지 않습니다.");
	            System.exit(0);
	        }
	     
	        try{
	             
	            // UDP 소켓 생성
	            DatagramSocket socket =new DatagramSocket();
	            // 전송할 곳이 주소생성
	            InetAddress ia = InetAddress.getByName("10.40.10.69");
	            // 파일 전송하기 위해 start라는 문자열 전송
	            String str ="start";
	            // 전송할 객체 생성
	            DatagramPacket dp =new DatagramPacket(str.getBytes(), str.getBytes().length);
	            // 전송
	            socket.send(dp);
	             
	            // 파일의 내용을 저장할 배열
	            byte [] by =new byte[512];
	             
	            // 모든 내용을 읽어서 전송
	            while(true){
	                int xx = dis.read(by, 0, by.length);
	                if(xx == -1)
	                    break;
	                    dp =new DatagramPacket(by, xx , ia , 9875);
	                 
	                str ="end";
	                dp =new DatagramPacket(str.getBytes(), str.getBytes().length,ia,9876);
	                socket.send(dp);
	             
	                dis.close();
	                socket.close();
	            }
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            }
	    }
	 
	}

