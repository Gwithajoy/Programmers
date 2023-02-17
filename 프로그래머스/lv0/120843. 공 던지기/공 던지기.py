
def solution(numbers, k):
    answer = 0
    new = numbers[:] + (numbers*k)
    answer = new[2*(k-1)]
    return answer
