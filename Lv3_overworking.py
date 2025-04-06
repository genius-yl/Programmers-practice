def solution(n, works):
    answer = 0
    works.sort(reverse=True)
    
    if sum(works) <= n: # 피로도 0
        answer = 0
    else:
        works.sort() #피로도 0이 아닌 경우 정렬함
        for _ in range(n): #n시간동안 진행
            works[-1] -= 1 #가장 큰 작업에서 1 줄이기
            works.sort() #다시 정렬해서 가장 큰 값을 맨 뒤로 보냄
            answer=sum([w**2 for w in works]) # 피로도 계산
        
    return answer
