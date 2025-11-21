class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] charS = s.toCharArray();
        int n = charS.length;
        Map<Character, int[]> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = charS[i];
            if(!map.containsKey(c)){
                int[] array = new int[3];
                array[0] = i;
                array[1] = i;
                array[2] = 1;
                map.put(c, array);
            } else{
                int [] array = map.get(c);
                array[1] = i;
                array[2]++;
            }
        }
        int count = 0;
        for(char it = 'a'; it<='z'; it++){
            if (map.containsKey(it)){
                int [] array = map.get(it);
                if(array[2] > 1){
                    int start = array[0] + 1;
                    int end = array[1] - 1;
                    Set<Character> set = new HashSet<>();
                    for(int j=start; j<=end; j++){
                        set.add(charS[j]);
                    }
                    count = count + set.size();
                }
            }
        }
        return count;
    }
}