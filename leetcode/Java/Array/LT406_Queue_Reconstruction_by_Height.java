class Solution {
    public int[][] reconstructQueue(int[][] people) { // 5ms 98.95% 按height从大到小 按k从小到大 然后list add(int index, E element)
        Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[0][0]);
    }
}