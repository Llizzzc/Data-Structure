/*
 * 1441. 用栈操作构建数组
 */
package BuildArray;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {
    public static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int j = -1;
        for (int i = 0; i < n; i++) {
            list.add("Push");
            if (target[++j] != i + 1) {
                list.add("Pop");
                j --;
            }
            if (target.length == j + 1) {
                break;
            }
        }
        return list;
    }
}
