class Solution {
    public double separateSquares(int[][] squares) {
        double low=0, high=1e9;
        double ans=0;

        for (int i=0;i<80;i++) {
            double mid=(low+high)/2;
            double bl=0, al=0;
            
            for (int j=0;j<squares.length;j++) {
                double l=squares[j][2];
                double y=squares[j][1];
                double area=l*l;

                if (y+l<=mid) bl+=area;
                else if (y>=mid) al+=area;
                else {
                    al+=((y+l-mid)*l);
                    bl+=((mid-y)*l);
                }
            }

            if (bl>=al) {
                ans=mid;
                high=mid;
            }
            else {
                ans=mid;
                low=mid;
            }
        } 

        return ans;
    }
}