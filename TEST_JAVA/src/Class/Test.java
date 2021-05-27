package Class;

public class Test {

	public static void main(String[] args) {
		TV t = new TV(); // t1이라는 TV객체 생성
		TV t2= new TV();
		t.channel = 11; // t1 채널 선언
		t2.channel = 13;
		
		t.channelUp();
		t.channelUp(); // TV.java에 있는 채널을 올리는 메소드를 실행
		
		t2.channelDown(); //TV.java에 있는 채널을 내리는 메소드를 실행
		t2.channelDown();
		t2.channelDown();

		System.out.println("현재 t의 채널은 "+t.channel+" 입니다.");
		System.out.println("현재 t2의 채널은 "+t2.channel+" 입니다.");
	}

}
