t = int(input())
while t > 0:
    t -= 1
    count, kill_signal = 0, 0
    n, c, d = map(int, input().split())
    b = list(map(int, input().split()))
    mi = min(b)
    a = []
    for col in range(0, n):
        for row in range(0, n):
            a += [mi + col * d + row * c]
    if sorted(a) == sorted(b):
        print('YES')
    else:
        print('NO')