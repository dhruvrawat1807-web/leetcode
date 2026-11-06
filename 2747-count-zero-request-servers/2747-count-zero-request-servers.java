import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b) -> a[1]-b[1]);

        int[][] q = new int[queries.length][2];
        for(int i=0;i<q.length;i++){
            q[i] = new int[]{queries[i],i};
        }
        Arrays.sort(q,(a,b)->a[0]-b[0]);

        int[] ans = new int[q.length];
        Map<Integer,Integer> map = new HashMap<>();
        int l=0, r=0;

        for(int[] a:q){
            int start=a[0]-x, end=a[0];

            while(r<logs.length && logs[r][1]<=end){
                map.merge(logs[r][0],1,Integer::sum);
                r++;
            }

            while(l<r && logs[l][1]<start){
                int id=logs[l++][0];
                map.put(id,map.get(id)-1);
                if(map.get(id)==0) map.remove(id);
            }

            ans[a[1]]=n-map.size();
        }
        return ans;
    }
}