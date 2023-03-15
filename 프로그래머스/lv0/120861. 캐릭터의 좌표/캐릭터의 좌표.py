def solution(keyinput, board):
    answer = []
    direction = {
        'up':[0,1],
        'down':[0,-1],
        'left':[-1,0],
        'right':[1,0]
    }
    x=y=0
    for key in keyinput:
        dx, dy = direction[key]
        nx, ny= x+dx, y+dy
        if abs(ny) <= (board[1] - 1) // 2 and abs(nx) <= (board[0] -1) // 2:
            x, y = nx, ny
    answer.append(x)
    answer.append(y)
    return answer