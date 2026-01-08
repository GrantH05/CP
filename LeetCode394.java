class Solution {
    public String decodeString(String s) {
        Stack <Integer> intStk= new Stack<>();
        Stack <StringBuilder> charStk= new Stack<>();
        StringBuilder sb= new StringBuilder();
        int k=0;

        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) k=(k*10)+(ch-'0');
            else if (ch=='[') {
                intStk.push(k);
                k=0;
                charStk.push(sb);
                sb=new StringBuilder();
            }
            else if (ch==']') {
                int p=intStk.pop();
                StringBuilder temp=charStk.pop();
                while (p-->0) temp.append(sb);
                sb=temp;
            }
            else sb.append(ch);
        }
        return sb.toString();
    }
}