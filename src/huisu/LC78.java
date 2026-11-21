package org.example.huisu;

import java.util.*;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 1
 *   1,2  1,3
 *    1,2,3
 * 2
 *   2,1 ,2,3
 * 3
 *  3,1 , 3,2
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class LC78 {

    //
    List<List<Integer>> result = new ArrayList<>();

    public LC78() {

    }

    public String sub(int[] array) {

        Set<int[]> set = new HashSet<>();
        //ArrayDeque deque = new ArrayDeque();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            result.add(new ArrayList<>());
            for (int j = i+1; j < array.length;i++) {
                
            }
            //set.add(new int[]{temp});

        }
        int start = 0;

        return "";
    }

    /**
     * temp result
     * 1  temp 0 result 1
     *  1,2  temp 1 result 1,2
     *  1,3 temp 1 result 13
     *  1,2,3 temp 1， 2 result 1,2,3
     * 2 temp 0 result 2
     *  2,3 temp 2 result 2，3
     * 3 temp 0  result 3
     *
     * @param array
     */
    public void subArray(int start, List<Integer> temp, List<Integer> res, List<Integer> array) {


        result.add(res);
        //temp = 0 res
        List  abc = temp;

        temp = new ArrayList<>(abc);

        /**
         * i = 0
         *   tm = 1
         *    递归 i = 1；
         *    tm  = 2
         *    递归 i = 2
         *    tm = 3
         */
        for (int i = start; i < array.size(); i++) {
            //0
            int tm = array.get(i);
            temp.add(tm);

            subArray(i + 1,res, temp, array);

        }


    }
}
