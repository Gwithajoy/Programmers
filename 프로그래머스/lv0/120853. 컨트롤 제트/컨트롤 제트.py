def solution(s):
    answer = 0
    sum = 0
    lst = list(s.split(" "))
    for i in range(len(lst)):
        if lst[i] != "Z":
            sum += int(lst[i])
        else:
            lst[i] = int(lst[i-1]) * -1
            print(sum)
            print(lst[i])
            sum+= int(lst[i])
    answer= sum
    return answer