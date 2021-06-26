import copy

def solution(participant, completion):
    answer = ''
    part = copy.deepcopy(participant)
    comp = copy.deepcopy(completion)
    
    for name in completion:
        if name in part:
            part.remove(name)
            comp.remove(name)
    answer = str(part[0])
    
    return answer