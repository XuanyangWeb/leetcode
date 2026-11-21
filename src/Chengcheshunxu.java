package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * # 1.乘车顺序
 * - 数组链表线性表
 * - 题目描述：
 * 中心小学在暑假期间组织学生参观，带队老师组织学生在操场上做游戏来决定大家的乘车顺序：
 * 老师随机给出两个学号A和B。若A同学当前位置在B同学之前（或重合），则将A和B之间的学生（包括A和B）按原顺序移到队伍最前面；若A当前位置在B之后，则将队列中B之前的所有学生（不包括B）移到队伍最末尾。
 * 学校共有X名学生(1<=X<=1200)，游戏开始时队列按学号递增排序，求经过Y轮(1<=Y<=X<=1200)之后的乘车顺序。
 *
 * - 输入：
 * X, Y：整型格式，表示总共有X名学生，完成Y轮游戏；
 * [[A1,B1],[A2,B2],...[AY,BY]]：数组格式，第一轮是学号A1到B1之间的同学按照规则进行游戏；第二轮是学号A2到B2之间的同学按照规则进行游戏；依次类推，第Y轮是学号AY到BY之间的同学按照规则进行游戏。
 *
 * # 补充说明：
 *
 *
 * ## 示例1
 * ### 输入：
 * 5,3,[[3,5],[5,1],[3,4]]
 * 学号[1,2,3,4,5]
 * ### 输出：
 * [3,4,5,1,2]
 * ### 说明：
 * - 学生初始乘车顺序为1,2,3,4,5；
 * - 第一轮游戏完成后，乘车顺序变为3,4,5,1,2；
 * - 第二轮游戏完成后，乘车顺序变为5,1,3,4,2；
 * -第三轮游戏完成后，乘车顺序变为3,4,5,1,2。
 * ## 示例2
 * ### 输入：
 * 6,2,[[2,5],[2,1]]
 * ### 输出：
 * [2,3,4,5,1,6]
 * 说明：
 * 学生初始乘车顺序为1,2,3,4,5,6；
 * 第一轮游戏完成后，乘车顺序变为2,3,4,5,1,6；
 * 第二轮游戏时，由于学号为2的学生已在队列首位，此时乘车顺序不会变化。
 * 示例3
 * 输入：
 * 6,3,[[3,5],[2,5],[2,2]]
 * 输出：
 * [2,5,1,6,3,4]
 * 说明：
 * 学生初始乘车顺序为1,2,3,4,5,6；
 * 经过第一轮游戏后，乘车顺序变为3,4,5,1,2,6；
 * 经过第二轮游戏后，乘车顺序变为5,1,2,6,3,4；
 * 第三轮相同学号，按重合场景排到队首规则处理，乘车顺序变为2,5,1,6,3,4。
 */
public class Chengcheshunxu {

    public List<Integer> game(int x, int y, int[][] rule) {
        List<Integer> student = createStudent(x);
        List<Integer> temp = new ArrayList<>(x);

        for (int i = 0; i < y; i ++) {
            temp = new ArrayList<>(x);
            int left = 0;
            int right = 0;
            int[] ruleItem = rule[i];
            int start = ruleItem[0];
            int end = ruleItem[1];

            List<Integer> a = new ArrayList<>();
            while (student.get(left) != start) {
                left++;
            }
            while (student.get(right) != end) {
                right++;
            }
            //位置在之后
            if (left > right) {
                List<Integer> pre = student.subList(right, student.size());
                List<Integer> suf = student.subList(0, right);
                temp.addAll(pre);
                temp.addAll(suf);
            } else {
                List<Integer> pre = student.subList(left, right + 1);
                List<Integer> mid = student.subList(0, left);
                List<Integer> suf = student.subList(right+1, student.size());
                temp.addAll(pre);
                temp.addAll(mid);
                temp.addAll(suf);
            }
            student = temp;

        }
        return student;
    }

    public List<Integer> createStudent(int length) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= length; i++ ) {
            result.add(i);
        }

        return result;
    }
}
