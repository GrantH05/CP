class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength=needle.length();
        int hayLength=haystack.length();
        int i=0,j,curr;

        while (i<hayLength) {
            curr=0;
            j=i;
            while (j<hayLength && curr<needleLength && haystack.charAt(j)==needle.charAt(curr)) {
                j++;
                curr++;
            }
            if (curr>=needleLength) return i;
            i+=1;
        }
        return -1;
    }
}