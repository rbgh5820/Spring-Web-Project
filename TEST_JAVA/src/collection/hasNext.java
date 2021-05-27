package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hasNext {

	public static void main(String[] args) {

		Set<String> set1 = new HashSet<>();
		 
        boolean flag1 = set1.add("kim");
        boolean flag2 = set1.add("lee");
        boolean flag3 = set1.add("park");
		
		Iterator<String> iter = set1.iterator(); // Iterator는 컬렉션 클래스에 데이터를 읽을때 사용.
        while (iter.hasNext()) {   // 꺼낼 것이 있다면 true 리턴.  (hasNext : 다음 원소가 남아있는지 여부를 알아낸다.)       
            String str = iter.next(); // next()메소드는 하나를 꺼낸다. 하나를 꺼내면 자동으로 다음것을 참조한다.
            System.out.println(str);
        }
	}

}
