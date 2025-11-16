class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        long count1 = 0;  
        long ans = 0;    

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;          
                ans = (ans + count1) % MOD;
            } else {
                count1 = 0;      
            }
        }

        return (int) ans;
    }
}