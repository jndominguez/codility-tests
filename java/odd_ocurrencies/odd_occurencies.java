class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int idx = 0;
        int totalMatches = 0;
        int unpairedItem = 0;
        
        if (A.length > 1){
            for(int i=0; i<A.length; i++){
                for(int j=0; j<A.length; j++) {
                    if (A[i] == A[j])
                        totalMatches++;
                }
                if (totalMatches % 2 > 0) {
                    unpairedItem = A[i];
                    break;
                }
                else
                    totalMatches = 0;
            }
        }
        else
            unpairedItem = A[0];
            
        return unpairedItem;
    }
}
