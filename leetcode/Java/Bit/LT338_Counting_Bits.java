// An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
/*
f[1] = f[1 / 2] + 1 % 2 = f[0] + 1 = 1
f[10] = f[2 / 2] + 2 % 2 = f[1] + 0 = 1
f[11] = f[3 / 2] + 3 % 2 = f[1] + 1 = 2
f[100] = f[4 / 2] + 4 % 2 = f[2] + 0 = 1

i / 2 -> i >> 1
i % 2 -> i & 1
*/

class Solution {
    public int[] countBits(int num) {  // time O(n) space O(n)
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}