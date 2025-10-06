def solution(phone_book):
    answer = True
    dct = {}
    for i in phone_book:
        dct[i] = 1
        
    for i in dct:
        check = ''
        for j in range(len(i)-1):
            check += i[j]
            if check in dct:
                return False
        
    return True