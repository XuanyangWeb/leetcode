package slide_windows;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *       [2,7,9,3,1,2,7] [1,1,1,1,3]
 */
public class LC198 {

    /**
     * {1,2,3,1}
     *  1
     *  1,2  2
     *  1,2,3 ,1,3
     *
     * @param nums
     * @return
     */
    public int steal(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = 0;

        int[] max = new int[nums.length];

        max[0] = nums[0];
        max[1] = nums[1] > max[0] ? nums[1] : max[0];
        for (int i = 0; i < nums.length; i++ ) {

            if (i < 2) {
                continue;
            }
            //如果偷当前的房子 大于 不偷
            //那么选择，当前的策略
            //为了方便下一次选现在的策略，还是选新的策略
            if ((nums[i] + max[i -2]) > max[i - 1]) {
                //max数组当前比nums少一位
                // max当前的位置，存储的是上一次最佳方案
                // 最大值
                max[i] = max[i - 2] + nums[i];
            } else {
                max[i] = max[i - 1];
            }

        }


        return Math.max(max[max.length - 1], max[max.length - 2]);
    }

}
