#그리디 문제
def solution(n, s):
    if s < n:
        return [-1]
#곱을 최대화하려면 숫자를 최대한 고르게 나눠야 함    
    base = s // n
    rest = s % n

    answer = [base] * n
    
    # 앞에서부터 1씩 더해서 나머지 분배
    for i in range(rest):
        answer[-1 - i] += 1  # 끝에서부터 채워야 오름차순 유지

    return sorted(answer)
