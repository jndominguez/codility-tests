#!/usr/bin/python3
import sys

def solution(s):
    steps = 0
    dec_input = int(s,2)
    while dec_input != 0:
        if dec_input % 2 == 0:
            dec_input = dec_input / 2
        else:
            dec_input = dec_input - 1
        steps += 1
    return str(steps)

if __name__ == "__main__":
    print("Input string: " + sys.argv[1])
    print("Result:       " + solution(str(sys.argv[1])))
