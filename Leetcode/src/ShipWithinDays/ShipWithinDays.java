/*
 * 1011. 在 D 天内送达包裹的能力
 */
package ShipWithinDays;

public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        // 两个极端情况，至少每天运输Max(weights[i])和sum(weights);
        int l = weights[0], r = weights[0];
        for (int i = 1; i < weights.length; i ++) {
            r += weights[i];
            if (l < weights[i]) {
                l = weights[i];
            }
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (days(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int days(int[] weights, int w) {
        int res = 0, sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (sum > w) {
                res++;
                sum = weight;
            }
        }
        res ++;
        return res;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println((new ShipWithinDays()).shipWithinDays(weights, 5));
    }
}
