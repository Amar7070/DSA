package Graph;
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n]; 
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        visited[i][j] = true;
                    }
                }
            }
        }
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int i=0;i<4;i++){
                int r = row + dr[i];
                int c = col + dc[i];
                if(r>=0 && c>=0 && r<m && c<n && !visited[r][c] && grid[r][c]==1){
                    q.add(new Pair(r,c));
                    visited[r][c] = true;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]) ans++;
            }
        }
        return ans;
    }
}