def solution(A):
    # write your code in Python 3.6
    sorted_arr = set(sorted(A))
    comp_array = []
    for i in range(len(A)):
        comp_array.append(i+1)
    if len(set(comp_array) - sorted_arr):
        result = min( set(comp_array) - sorted_arr )
    else:
        if max(sorted_arr) < 0:
            result = 1
        else:
            result = max(sorted_arr) + 1
    return result
    
