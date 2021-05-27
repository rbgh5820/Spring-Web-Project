package collection;

import java.util.LinkedList;
import java.util.Iterator;

public class Linked1 {

	public static void main(String[] args) {
		LinkedList<Integer> List = new LinkedList<Integer>();
		
		List.add(7);
		List.addFirst(17); //가장 앞에 데이터를 추가
		List.add(47);
		List.add(3);
		List.add(5);
		List.add(27);
		
		
		Iterator it=List.iterator(); // 탐색을 위한 Iterator 객체를 생성
		
		while(it.hasNext()) { // 다음 인덱스 값이 있는지 체크하고 없을때까지 반환
			System.out.println(it.next()+" ");
		}
		System.out.println("====================");
		System.out.println(List.size());// List의 크기를 출력
		System.out.println(List.contains(30)); // add 데이터값에 30이 있는지 true false로 체크
		
	}

}
