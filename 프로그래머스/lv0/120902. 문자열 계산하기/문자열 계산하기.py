def solution(my_string):
    a = my_string.split()
    answer = int(a[0])
    for i in range(1,len(a),2):
        if a[i] == "+":
            answer += int(a[i+1])
        else:
            answer -= int(a[i+1])
    return answer