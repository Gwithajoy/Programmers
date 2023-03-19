def solution(M, N):
    answer = 0
    if N == 1:
        answer = M-1
    else: 
        answer = M*N -1
    return answer