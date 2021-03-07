class Solution {
    public int[] solution(int brown, int yellow) {
        /*문제명: 카펫
        1) yellow와 brown의 관계를 모색해야 함.
        - 가로*세로 = yellow +brown
        - yellow = (가로-2)*(세로-2)
        - brown = 2*가로+2*세로-4
        2)


        */

		int height = 0;
		int width = 0;

		for (height = 3; height <= (int) (brown + 4) / 2; height++) {
            //갈색2개 노랑1개 필수이므로 3부터 시작
			width = ((brown + 4) / 2) - height;
			if (width < height) {
                //가로가 세로길이보다 길다.
				break;
			}
			int yCount = (width - 2) * (height - 2);
            //노랑색 길이 공식으로 계산
			if (yellow == yCount) {
                //노랑색 값 찾으면 멈춤
				break;
			}
		}

		int[] answer = new int[] { width, height };
		return answer;
	}
}
