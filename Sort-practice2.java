import java.util.Arrays;
import java.util.Comparator;

class Solution {
    /*문재명: 가장 큰 수  
    1) 각 문자를 붙인 값을 String으로 우선적으로 만들어준다.
    2) 각 값을 계속 붙여가며 크기를 비교한다.
    3) 0으로 시작하는 수가 아니면, 최종적으로 배열을 연결하여 answer로 출력한다.
    */

    public String solution(int[] numbers) {
        String answer = new String();
        String str_numbers[] = new String[numbers.length];
	    for(int i=0; i<str_numbers.length; i++) {
		    str_numbers[i] = String.valueOf(numbers[i]);
	    }

	    Arrays.sort(str_numbers, new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return (o2+o1).compareTo(o1+o2);
		}
	});

	    if(str_numbers[0].startsWith("0")) {
		    answer += "0";
	    } else {
		    for(int j=0; j<str_numbers.length; j++) {
		    	answer += str_numbers[j];
		    }
	    }
        return answer;
    }
}
