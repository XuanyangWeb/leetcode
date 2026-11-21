
import org.example.Chengcheshunxu;
import org.example.bfs.LC200;
import org.example.huisu.LC78;
import org.example.slide_windows.LC34;
import slide_windows.LC198;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

void main() {

    testLc34();

}
void testLc34() {

    int[] param = {5,7,7,8,8,10};
    LC34 lc34 = new LC34();
    //System.out.println(Arrays.toString(lc34.binarySearch(param, 7)));
    System.out.println(Arrays.toString(lc34.binarySearch(param, 8)));
    System.out.println(Arrays.toString(lc34.find(param, 8, 0)));
    System.out.println(Arrays.toString(lc34.binarySearch(param, 6)));
    int[] param1 = {1, 2, 3, 3, 3, 3, 4, 5};
    /**
     * mid = 4
     * mid > 3
     */
    System.out.println(Arrays.toString(lc34.binarySearch(param1, 3)));
    //int[] param = {5,7,7,8,8,10};
}
void test78() {
    LC78 lc78 = new LC78();
    int[] param1 = {1,2,3};
    List<Integer> a = Arrays.stream(param1).boxed().collect(Collectors.toUnmodifiableList());

    lc78.subArray(0, new ArrayList<>(),new ArrayList<>(), a);
}
void test198() {
    LC198 lc198 = new LC198();
    int[] num1 = {1, 2, 3, 1};
    int[] num2 = {2, 7, 9, 3, 1, 2, 7};
    int[] num3 = {2, 7, 9, 3, 1};
    int[] num4 = {1, 1, 1, 1, 3};

    System.out.println(lc198.steal(num1));
    System.out.println(lc198.steal(num2));
    System.out.println(lc198.steal(num3));
    System.out.println(lc198.steal(num4));
}

static void testBFS() {
    char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};

    char[][] grid1 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    LC200 lc200 = new LC200();
    System.out.println(lc200.find(grid));
    System.out.println(lc200.find(grid1));
}

static void testChengche() {
    /**
     *  * 5,3,[[3,5],[5,1],[3,4]]
     *  * 学号[1,2,3,4,5]
     *  * ### 输出：
     *  * [3,4,5,1,2]
     *  * ### 说明：
     *  * ## 示例2
     *  * ### 输入：
     *  * 6,2,[[2,5],[2,1]]
     *  * ### 输出：
     *  * [2,3,4,5,1,6]
     *  * 示例3
     *  * 输入：
     *  * 6,3,[[3,5],[2,5],[2,2]]
     *  * 输出：
     *  * [2,5,1,6,3,4]

     */
    Chengcheshunxu demo = new Chengcheshunxu();
    int[][] param1 = {{3, 5}, {5, 1}, {3, 4}};
    int[][] param2 = {{2, 5}, {2, 1}};

    List<Integer> res1 = demo.game(5, 3, param1);
    System.out.println(res1.toString());
    List<Integer> res2 = demo.game(6, 2, param2);
    System.out.println(res2.toString());

    int[][] param3 = {{3, 5}, {2, 5}, {2, 2}};
    List<Integer> res3 = demo.game(6, 3, param3);
    System.out.println(res3.toString());
}
