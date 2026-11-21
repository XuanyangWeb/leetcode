package org.example.slide_windows;

/**
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class LC34 {

    //双指针
    public int[] find(int[] ints, int target) {
        int left = 0;
        int rigt = ints.length - 1;
        int[] result = {-1, -1};
        while (left <= rigt) {

            if (result[0] == -1
                    && ints[left] == target) {
                result[0] = left;
            }
            if (result[1] == -1
                    && ints[rigt] == target) {
                result[1] = rigt;
            }
            if (rigt <= left) {
                break;
            }

            left++;
            rigt--;


        }
        return result;
    }


    //{1, 2, 3, 3, 3, 3, 4, 5}
    public int[] binarySearch(int[] ints, int target) {
        int[] result = {-1, -1};
        int mid = ints.length / 2;
        int left = 0;
        int right = ints.length - 1;
        int left1 = -1;
        int right1 = -1;
        left1 = searchLeft(ints, 0, ints.length - 1, target);
        right1 = searchRight(ints, 0, ints.length - 1, target);

        if (left1 > right1) {
            int temp = right1;
            right1 = left1;
            left1 = temp;
        }


            result[0] = left1;
        result[1] = right1;
        //找右边界

        return result;
    }


    public int searchRight(int[] ints, int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            if (ints[right] == target) {
                result = right;
            }
            int mid = left + ((right - left) / 2);
            /**
             * [5, 7, 7,7, 7, 10]
             * mid = 2 7
             * 如果目标 8 在 右侧  左侧收缩
             *     目标8 在 左侧
             */
            //如果目标值在mid左侧
            if (ints[mid] <= target ) {
                if (ints[mid] == target) {
                    result = mid;
                }
                left = mid + 1;
                //在右侧
            } else {

                right = mid - 1;
            }

        }
        return result;
    }


    public int searchLeft(int[] ints, int left, int right, int target) {
        int result = -1;
        //找左边界
        while (left <= right) {
            //{1, 2, 3, 3, 3, 3, 4, 5}


            //ints[right] = right;
            int mid = left + (right - left) / 2;

            //如果目标值在左侧
            /**
             * [5, 7, 7, 8, 8, 10]
             * mid = 2
             * 如果目标 8 在 右侧  左侧收缩
             *     目标8 在 左侧
             *     判断条件 中间值 > 目标值
             *     [5, 7, {7}, 8, 8, 10]
             */
            //如果当前值小于 taget
            if (ints[mid] >= target) {
                if (ints[mid] == target) {
                    result = mid;
                }
                right = mid - 1;
            } else {
                 left = mid+1;
            }

        }
        return result;
    }
    public int[] find(int[] nums, int target, int kk) {
        int leftBound = findLeftBound(nums, target);
        int rightBound = findRightBound(nums, target);

        // 验证找到的边界是否有效（即 target 确实存在）
        if (leftBound <= rightBound && rightBound < nums.length &&
                nums[leftBound] == target && nums[rightBound] == target) {
            return new int[]{leftBound, rightBound};
        }
        return new int[]{-1, -1};
    }

    // 寻找第一个 >= target 的位置（左边界）
    private int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length; // 初始化为越界值
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1; // 继续向左收缩，寻找更左边的 target
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 寻找最后一个 <= target 的位置（右边界）
    private int findRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1; // 继续向右收缩，寻找更右边的 target
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
