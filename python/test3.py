#!/usr/bin/python3
import sys

def solution(s):
    heads = 0
    tails = 0
    coins = s.split(",")
    for i in range(len(coins)):
        if coins[i] == '0':
            heads += 1
        else:
            tails += 1
    return (str(tails) if heads > tails else str(heads))

if __name__ == "__main__":
    print("Input string: " + sys.argv[1])
    print("Result:       " + solution(str(sys.argv[1])))
