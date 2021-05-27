package map;

import java.util.HashMap;

public class MapSample3 {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<String,Integer>(); // HashMap을 <String,Integer>로 생성
		
		map.put("김규호",new Integer(90));
		map.put("둘리",new Integer(40));
		map.put("또치",new Integer(50));
		map.put("홍길동",new Integer(80));
		map.put("김규호",new Integer(100)); // key값은 중복되지 않기때문에 덮어쓰기가 된다.
		map.put(null,new Integer(10));
		
		System.out.println(map); // map의 key,value의 값을 모두출력
		
		Integer num = map.get("둘리"); //map.get("둘리")의 성적을 정수형인 num에 저장한다.
		Integer num1 = map.get("김규호"); // 19와 마찬가지로 김규호의 성적을 num1에 저장한다.
		System.out.println("둘리의 성적은? : "+num); // num값 출력
		System.out.println("김규호의 성적은? : "+num1); // num1 값 출력
		
		num = map.get(null);
		System.out.println("null의 성적은? "+num); // Integer는 null값을 허용한다.
	}

}
