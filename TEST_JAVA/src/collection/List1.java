package collection;

import java.util.*;

public class List1 {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>(); //객체 생성

		arrList.add(100); // 위에 생성한 객체의 메소드를 생성 add()
		arrList.add(80);
		arrList.add(10);
		arrList.add(17);
		arrList.add(47);

		for (int i = 0; i < arrList.size(); i++) { // i=0, i가 arrList size보다 작을때까지 i 1씩증가
			System.out.print(arrList.get(i) + " ");
		}
		System.out.println();
		
		arrList.remove(3); // arrList 항목을 제거 add 메소드가 5개이므로 0~4숫자중 하나 입력

		for (int e : arrList) { // 배열 요소 값을 순서대로 하나씩 가져와서 변수에 대입하는 향상된 for문
			System.out.print(e + " ");
		}
		System.out.println();
		Collections.sort(arrList); // arrList를 오름차순 정렬(정렬방법)

		// iterator() 메소드와 get() 메소드를 이용한 요소의 출력
		Iterator<Integer> iter = arrList.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " "); //hasNext()로 읽어올수 있는 List가 있는지 확인하고 있으면 next()로 다음 리스트값 출력
		}
		System.out.println();

		// set() 메소드를 이용한 요소의 변경
		arrList.set(0, 20); // 첫번째 arrList의 값을 20으로 변경하는 코드 기존 1번째 arrList값은 100
		for (int e : arrList) {
			System.out.print(e + " ");
		}
		System.out.println(); // println : 줄바꿈

		System.out.println("리스트의 개수 : " + arrList.size()); // 리스트의 크기(개수)
	}
}
