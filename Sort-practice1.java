import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        /* 문제명: K번째수
        1) (i,j) 범위의 배열을 가져오기
        2) 배열을 오름차순으로 정렬
        3) 오름차순 배열의 K번째 수 찾기
        */
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++) {
            //1) (i,j) 범위의 배열을 가져오기
            int temp[] = new int [commands[i][1]-commands[i][0]+1];
            for(int j=0;j<temp.length;j++) {
                temp[j] = array[j+(commands[i][0]-1)];
            }
            //2) 배열을 오름차순으로 정렬
            Arrays.sort(temp);
            //3) 오름차순 배열의 K번째 수 찾기
            answer[i] = temp[commands[i][2]-1];
        }


        return answer;
    }
}
