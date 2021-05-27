package inheritance;

public class InherTest {

	public static void main(String[] args) {
		Manager mng=new Manager("김규호",2000000,"솔루션개발부");//Manager클래스의 객체 생성후 인수 전달
		Manager mng1=new Manager("홍길동",2500000,"연구개발부");
		
		mng.getInformation(); //메소드 실행
		mng1.getInformation();//메소드 실행
		}

}
