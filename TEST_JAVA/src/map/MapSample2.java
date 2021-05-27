package map;

import java.util.HashMap;

public class MapSample2 {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("기린", "초식동물"); //put()메소드로 키와 값 입력.
		map.put("사자", "육식동물");
		map.put("사람", "동물");
		map.put("컨퍼스", "도구");
		
		for(String key:map.keySet()) { // keySet()으로 키 값을 가져왔다.
			System.out.print(map.get(key)+" / ");
		}
		for(HashMap.Entry<String,String> entry : map.entrySet()) { // entrySet() : 키,값을 모두 가져왔다.
			System.out.print(entry + " / ");
		}
		System.out.println(map.size());
	}

}
