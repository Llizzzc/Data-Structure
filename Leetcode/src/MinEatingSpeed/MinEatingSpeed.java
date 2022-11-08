/*
 * 875. 爱吃香蕉的珂珂
 */
package MinEatingSpeed;

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        // 两种极端情况，1h吃一根和1h吃Max(piles[i])根
        int l = 1, r = piles[0];
        for (int i = 1; i < piles.length; i ++) {
            if (piles[i] > r) {
                r = piles[i];
            }
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int eatingTime(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            res += pile / k + (pile % k > 0? 1: 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println(new MinEatingSpeed().minEatingSpeed(piles, 8));
    }
}
