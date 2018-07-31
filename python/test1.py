#!/usr/bin/python3
import sys

org_s = ''

def shift_s(s,n):
    global org_s
    head = s[0:n]
    org_s = s[n:]
    return head

def solution(s):
    global org_s
    numbers = []
    org_s = s.replace(" ", "").replace("-","")
    while len(org_s) > 3:
        if len(org_s) == 4:
            numbers.append(shift_s(org_s,2))
        else:
            numbers.append(shift_s(org_s,3))
    numbers.append(org_s)
    return '-'.join(numbers)

if __name__ == "__main__":
    print("Input string: " + sys.argv[1])
    print("Result:       " + solution(str(sys.argv[1])))
