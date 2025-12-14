class Solution {
    public int numberOfWays(String corridor) {
        int start = 0, end = corridor.length() - 1;

        while(start < corridor.length() && corridor.charAt(start) == 'P'){
            start++;
        }

        while(end >= 0 && corridor.charAt(end) == 'P'){
            end--;
        }

        int seatCount = 0;
        long ways = 1;
        int mod = 1_000_000_007;
        while(start <= end){
            int currSeatCount = 1, currPlantCount = 1;
            while(start <= end && currSeatCount <= 2){
                if(corridor.charAt(start) == 'S'){
                    currSeatCount++;
                    seatCount++;
                }
                start++;
            }

            while(start <= end && corridor.charAt(start) == 'P'){
                currPlantCount++;
                start++;
            }

            ways = (ways * currPlantCount) % mod;
        }

        return seatCount % 2 == 1 || seatCount == 0 ? 0 : (int)ways;
    }
}