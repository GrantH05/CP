class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long res=0;
        int curr=0;
        int m=Integer.MAX_VALUE;
        int n=matrix.length;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j]<0) curr+=1;
                m=Math.min(m,Math.abs(matrix[i][j]));
                res+=Math.abs(matrix[i][j]);
            }
        }

        if (curr%2==1) res-=(2*m);
        return res;
    }
}
