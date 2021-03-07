import java.util.*;
//문제명: 디스크 컨트롤러
//어려운 문제
//가장 작업 시간이 짧은 것부터 처리하되, 시작 시간을 꼭 고려해야 함.
class Solution {
    class Job {
        int startTime;
        int workingTime;
        //새로운 Job이라는 클래스의 메서드 정의
        Job(int startTime, int workingTime){
            this.startTime = startTime;
            this.workingTime = workingTime;
        }
    }

    public int solution(int[][] jobs) {
    	LinkedList<Job> waiting = new LinkedList<>();
        //새로운 정렬 방식을 정의하기 위해 Comparator 재정의
    	PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
    		@Override
    		public int compare(Job j1, Job j2) {
    			return j1.workingTime - j2.workingTime;
    		}
    	});

    	for(int[] job : jobs) {
    		waiting.offer(new Job(job[0], job[1]));
    	}

    	Collections.sort(waiting, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return j1.startTime - j2.startTime;
			}
    	});

    	int answer = 0;
    	int cnt = 0;
    	int time = waiting.peek().startTime;

    	while(cnt < jobs.length) {
    		while(!waiting.isEmpty() && waiting.peek().startTime <= time) {
    			pq.offer(waiting.pollFirst());
    		}

    		if(!pq.isEmpty()) {
    			Job job = pq.poll();
    			time += job.workingTime;
    			answer += time - job.startTime;
    			cnt++;
    		} else {
    			time++;
    		}
    	}

    	return answer / cnt;
    }
}
