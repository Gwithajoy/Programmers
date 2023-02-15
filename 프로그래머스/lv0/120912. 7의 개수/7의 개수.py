def solution(array):
    answer=0
    for a in array:
        find_7 = str(a).count('7')
        answer += find_7
    return answer


def solutions(array):
    return str(array).count('7')