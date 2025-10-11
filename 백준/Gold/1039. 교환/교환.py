def supernova(level, info):
    global ans
    if len(info) == 1:
        return

    if info[0] == '0':
        return
    val = int(''.join(info))
    if (val, level) in check:
        return
    # print(val)

    check.add((val, level))
    if level == N:
        ans = max(ans ,val)
        return


    for i in range(len(info)):
        for j in range(len(info)):
            if i != j:
                info[i], info[j] = info[j], info[i]
                supernova(level + 1, info)
                info[i], info[j] = info[j], info[i]




info1 = list(input().split())
# print(info1)
N = int(info1.pop())
# info1.pop()
ans = -1
check = set()
info1 = list(info1[0])
# print(info1, N)
supernova(0, info1)
print(ans)