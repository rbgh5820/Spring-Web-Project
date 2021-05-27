package map;

import java.util.HashMap;

public class MapSample {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>(); // Hash map에 데이터를 넣기(key,value)
        map.put("people", "사람"); // key = people,value = 사람
        map.put("baseball", "야구"); //put()은 데이터를 넣어주는 메소드

        
        // 결과값 출력
        System.out.println(map.get("people")); // get은 put에 넣은 데이터를 꺼내오는 메소드
        System.out.println(map.containsKey("people"));
        System.out.println(map.remove("baseball"));
        System.out.println(map.size());
    }
}