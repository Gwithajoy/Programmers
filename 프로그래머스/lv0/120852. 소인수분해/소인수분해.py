def solution(n):
    answer = []
    t = 2
    while t <= n:
        if n % t == 0:
            if t in answer:
                pass
            else:
                answer.append(t)
            n = n / t
        else:
            t = t + 1
    return answer