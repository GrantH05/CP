class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        r=len(matrix)
        c=len(matrix[0])
        res=0
        l=[0]*c
        for i in range(0,r):
            for j in range(0,c):
                if matrix[i][j]=="1":
                    l[j]+=1
                else:
                    l[j]=0
            stk=[]
            for j in range(c+1):
                if j<c:
                    curr=l[j]
                else:
                    curr=0
                while stk and curr<l[stk[-1]]:
                    h=l[stk[-1]]
                    stk.pop()
                    if not stk:
                        w=j
                    else:
                        w=j-1-stk[-1]
                    res=max(res,h*w)
                stk.append(j)

        return res

