class Solution:
    def decimalRepresentation(self, n: int) -> List[int]:
        s = str(n)
        res = []
        for i, char in enumerate(s):
            digit = int(char)
            if digit != 0:
                power = len(s) - 1 - i
                component = digit * (10 ** power)
                res.append(component)
        return res