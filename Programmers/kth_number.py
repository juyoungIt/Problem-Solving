def solution(array, commands):
    answer = []
    for command in commands:
        start = command[0]-1
        end = command[1]
       	part_list = array[start:end]
        part_list.sort()
        answer.append(part_list[command[2]-1])
    return answer