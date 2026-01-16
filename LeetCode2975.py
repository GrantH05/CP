class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        mod=10**9 + 7
        hFences.extend([1,m])
        vFences.extend([1,n])
        hFences.sort()
        vFences.sort()
        s=set()
        res=0
        
        for i in range(0,len(hFences)):
            for j in range(i+1, len(hFences)):
                s.add(hFences[j]-hFences[i])

        for i in range(0,len(vFences)):
            for j in range(len(vFences)-1, i, -1):
                curr=vFences[j]-vFences[i]
                if curr in s:
                    res=max(res,curr*curr)
                    break
                
        return res%mod if res>0 else -1
                