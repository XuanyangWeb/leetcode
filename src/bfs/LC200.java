package org.example.bfs;

import java.util.ArrayDeque;
import java.util.List;

/**
 * LC200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class LC200 {

    private static final int RADIX = 10;
    public int find(char[][] param) {
        int xLength = param.length;
        int yLength = param[0].length;
        int count = 0;

        //存放坐标用于便利
        ArrayDeque<int[]> queue = new ArrayDeque();

        int[] nx = {-1,1,0,0};
        int[] ny = {0,0,1,-1};
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {

                if (param[x][y] == '1') {
                    count++;
                    queue.offer(new int[]{x,y});
                    param[x][y] = '0';
                }
                while (!queue.isEmpty()) {
                    int[] temp = queue.poll();
                    int xx = temp[0];
                    int yy = temp[1];
                        //上下左右扩张四次
                    /**
                     * {'1', '1', '0', '0', '0'},
                     *                 {'1', '1', '0', '0', '0'},
                     *                 {'0', '0', '1', '0', '0'},
                     *                 {'0', '0', '0', '1', '1'}
                     */
                        for (int k = 0; k < 4; k++) {
                            int xOffset = xx + ny[k];
                            int yOffset = yy + nx[k];
                            if (xOffset < xLength && xOffset >= 0
                                    && yOffset < yLength && yOffset >= 0
                                    && param[xOffset][yOffset] == '1') {
                                queue.offer(new int[] {xOffset,yOffset});
                                param[xOffset][yOffset] = '0';
                        }

                    }

                }

            }
        }


        return count;
    }


}
