import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        /*문제명: H-index  
        핵심: n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
        h의 최댓값이 이 과학자의 H-Index입니다.
        citations을 오름차순으로 정렬하고, 각 배열의 값을 h로 뒀을 때, 논문의 편수가 h인 값을 찾기
        */
        Arrays.sort(citations);//오름차순 정렬

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
                //그 이상의 경우에는 h의 편수가 부족함
            }
        }

        return answer;
    }
}
