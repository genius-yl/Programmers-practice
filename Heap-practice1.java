import java.util.PriorityQueue;
//문제명: 더 맵게
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        /* [첫번째 방법]
        1) 오름차순으로 배열이 정렬된다고 가정
        2) 가장 작은 두 개의 수를 뽑아내야 함(a,b)
        3) 새로운 스코빌 지수가 만들어지면, a,b를 없애고, 새로운 스코빌 지수를 넣어야 함
        4) 다시 배열 오름차순 정렬
        단점: 오름차순 정렬을 다시 하면서 실행시간이 초과되어 효율성이 낮음
        */

        /* [두번째 방법]
        우선순위 큐를 사용하여 힙(완전이진트리) 형태로 정렬한다.(오름차순 정렬 가능)
        1) 우선순위 큐 오름차순으로 정렬한다.
        2) 가장 작은 수 a,b를 저장하고, 큐에서 poll(데이터 출력+제거)한다.
        3) 새롭게 생성된 scoville 지수를 저장한다.
        */
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for(int i:scoville) {
            //배열을 우선순위 큐로 저장
            q.offer(i);
        }

        while(q.peek()<=K) {
            //스코빌 지수가 연산이 끝날 때까지(1개가 남을 때까지) K 미만이면 -1 반환
            if(q.size()==1) {
                return -1;
            }
            //가장 작은 두 수 저장하고 제거
            int a = q.poll();
            int b = q.poll();
            //result에 스코빌 연산을 저장
            int result = a+(b*2);
            //result를 큐에 삽입
            q.offer(result);
            answer++;
        }
        return answer;
    }
}
