class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int n = scores.length;

        int[][] players = new int[n][2];

        for(int i=0; i<n; i++){
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }

        Arrays.sort(players, (a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]): Integer.compare(a[1], b[1]));

        int[] dp = new int[n];
        int maxScore = 0;

        for(int i = 0; i < n; i++){
            int currScore = players[i][0];
            int currAge = players[i][1];

            dp[i] = currScore;

            for(int j = 0; j < i; j++){
                int prevAge = players[j][1];

                if(currAge >= prevAge) {
                    dp[i] = Math.max(dp[i], dp[j] + currScore);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }
        return maxScore;
    }
}