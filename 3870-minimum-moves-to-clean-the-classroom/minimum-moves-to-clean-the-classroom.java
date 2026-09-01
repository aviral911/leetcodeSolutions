import java.util.*;

class Solution {

    static class State {
        int r, c, energy, mask, dist;

        State(int r, int c, int energy, int mask, int dist) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.dist = dist;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;

        Map<Integer, Integer> litterId = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    litterId.put(i * n + j, idx++);
                }
            }
        }

        int allMask = (1 << idx) - 1;

        Queue<State> q = new LinkedList<>();

        boolean[][][][] vis =
                new boolean[m][n][energy + 1][1 << idx];

        q.offer(new State(sr, sc, energy, 0, 0));
        vis[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.mask == allMask)
                return cur.dist;

            if (cur.energy == 0)
                continue;

            for (int k = 0; k < 4; k++) {

                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X')
                    continue;

                int newEnergy = cur.energy - 1;
                int newMask = cur.mask;

                if (cell == 'L') {
                    int bit = litterId.get(nr * n + nc);
                    newMask |= (1 << bit);
                }

                if (cell == 'R') {
                    newEnergy = energy;
                }

                if (!vis[nr][nc][newEnergy][newMask]) {
                    vis[nr][nc][newEnergy][newMask] = true;
                    q.offer(new State(
                            nr, nc,
                            newEnergy,
                            newMask,
                            cur.dist + 1));
                }
            }
        }

        return -1;
    }
}