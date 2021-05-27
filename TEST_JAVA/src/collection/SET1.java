package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SET1 {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		 
        boolean flag1 = set1.add("kim");
        boolean flag2 = set1.add("lee");
        boolean flag3 = set1.add("kim");
 
        System.out.println(set1.size());   // size(저장된 set1 add메소드의 갯수)
        System.out.println(flag1);  //true값이 나올것이다(boolean은 true false값으로 출력)
        System.out.println(flag2);  //
        System.out.println(flag3);  //false 위에서 같은 kim의값이 이미 들어가 있기때문, Set은 중복이 불가능하다.
    }
}