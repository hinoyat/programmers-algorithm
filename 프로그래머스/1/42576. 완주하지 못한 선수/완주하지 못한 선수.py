def solution(participant, completion):
    dct = {}
    answer = ''
    for i in participant:
        try:
            dct[i] += 1
        except:
            dct[i] = 1

    for j in completion:
        dct[j] -= 1
        if dct[j] == 0:
            del dct[j]
    
    ans = list(dct.keys())
    answer = ans[-1]
    return answer