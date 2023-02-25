def solution(s):
    answer =0
    stack = []
    for i in s.split(' '):
        if i != 'Z':
            stack.append(int(i))
        else:
            stack.pop()
        answer = sum(stack)
    return answer