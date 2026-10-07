class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        if(n <= 1)
            return 0;

            int[] cuts = new int[n];

            boolean[][] isPallindrome = new boolean[n][n];

            for(int i = 0; i < n; i++){
                int minCuts = i;

                for(int j = 0; j <= i; j++){
              if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPallindrome[j+1][i-1])){
                isPallindrome[j][i] = true;

                if(j == 0){
                    minCuts = 0;
                } else {
                    minCuts = Math.min(minCuts, cuts[j-1] + 1);
                }
                }
                }
                cuts[i] = minCuts;
            }
            return cuts[n-1];
        
    }
}