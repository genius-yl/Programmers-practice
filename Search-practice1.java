import java.util.*;

class Solution {
    /*문제명: 모의고사
    1) 각 규칙을 변수에 저장한다.
    2) 주어진 정답과 매치하여 맞은 개수를 저장한다.
    3) 7가지 경우의 수에 따라서 answer 반환한다.
    배열은 초기 길이를 선언해야하므로, ArrayList로 변환한 뒤에 이를 배열로 재선언 해야한다.
    */

    public int[] solution(int[] answers) {
        ArrayList<Integer> arrList = new ArrayList<>();
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int aa=0;
        int bb=0;
        int cc=0;

        for(int i=0;i<answers.length;i++) {
            if(answers[i] == a[i%5]) {
                aa++;
            }
            if(answers[i] == b[i%8]) {
                bb++;
            }
            if(answers[i] == c[i%10]) {
                cc++;
            }
        }
        //7가지의 경우의 수

        if(aa>bb && aa>cc) {
            arrList.add(1);
        } else if(bb>aa && bb>cc) {
            arrList.add(2);
        } else if(cc>aa && cc>bb) {
            arrList.add(3);
        }
        else if(bb==aa && bb>cc) {
            arrList.add(1);
            arrList.add(2);
        } else if(bb==cc && bb>aa) {
            arrList.add(2);
            arrList.add(3);
        } else if(cc==aa && aa>bb) {
            arrList.add(1);
            arrList.add(3);
        }
        else if(bb==aa && aa==cc) {
            arrList.add(1);
            arrList.add(2);
            arrList.add(3);
        }

        int[] answer = new int[arrList.size()];

        for(int k=0;k<arrList.size();k++) {
            answer[k] = arrList.get(k);
        }
        return answer;
    }
}
