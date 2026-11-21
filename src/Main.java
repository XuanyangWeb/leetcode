import double_point.LC88;
import slide_windows.LC198;
import slide_windows.LC209;
import stack.LC20;
import tanxin.LC455;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
void main() {
    LC198 lc198 = new LC198();
    int[] num1 = {1,2,3,1};
    int[] num2 = {2,7,9,3,1,2,7};
    int[] num3 = {2,7,9,3,1};
    int[] num4 = {1,1,1,1,3};

    System.out.println(lc198.steal(num1));
    System.out.println(lc198.steal(num2));
    System.out.println(lc198.steal(num3));
    System.out.println(lc198.steal(num4));

}
