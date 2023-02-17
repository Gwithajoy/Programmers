def solution(numbers):
    answer = 0
    lst = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    for i,l in enumerate(lst):
        numbers = numbers.replace(l,str(i))
    return int(numbers)