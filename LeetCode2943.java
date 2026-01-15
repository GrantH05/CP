class Solution {
    private int barCheck(int [] bars) {
        Arrays.sort(bars);
        int res=1;
        int curr=1;
        for (int i=1;i<bars.length;i++) {
            if (bars[i]-bars[i-1]==1) curr++;
            else curr=1;
            res=Math.max(res,curr);
        }
        return res+1;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        return (int)Math.pow(Math.min(barCheck(hBars),barCheck(vBars)),2);
    }
}