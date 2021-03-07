import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        /* 문제명: 이중우선순위큐
        1) 내림차순, 오름차순의 우선순위 큐를 동시에 만들어줌
        2) 새로운 값은 두 우선순위 큐에 동시에 넣어줌
        3) 최솟값이면 내림차순의 peek, 최댓값이면 오름차순의 peek
        4) 그리고 두 우선순위 큐에서 동시에 제거해줘야 함
        */
        int[] answer = {0,0};
        //최댓값은 내림차순, 최솟값은 오름차순으로 정렬하는 우선순위 큐 만들기

        PriorityQueue<Integer> Max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> Min = new PriorityQueue<>();

        for (String operation : operations) {
            String[] splitOther = operation.split(" ");
            //각 배열의 값을 자른 값을 저장함.
            //만약에 I가 있는 경우는 그 뒤의 수를 각 큐에 넣어야 함
            if (splitOther[0].equals("I")) {
                Max.add(Integer.parseInt(splitOther[1]));
                Min.add(Integer.parseInt(splitOther[1]));
            }
            //만약에 D가 있고, 여기서 1이 나오면 최댓값, -1이 나오면 최솟값 빼야 함
            if (splitOther[0].equals("D")) {
                if (!Max.isEmpty()) {
                    if (splitOther[1].equals("1")) {
                        int max = Max.peek();
                        Max.remove(max);
                        Min.remove(max);

                    } else {
                        int min = Min.peek();
                        Max.remove(min);
                        Min.remove(min);
                    }
                }
            }

        }
        //큐가 비지 않았다면, 각 최댓값과 최솟값을 저장해야 함
        if (!Max.isEmpty()) {
            answer[0] = Max.peek();
            answer[1] = Min.peek();

        }
        return answer;
    }
}
