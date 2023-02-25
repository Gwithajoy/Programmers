def solution(s):
    answer = 0
    lst = list(s.split(" "))
    for i in range(len(lst)):
        if lst[i] != "Z":
            answer += int(lst[i])
        else:
            lst[i] = int(lst[i-1]) * -1
            answer+= int(lst[i])
    return answer