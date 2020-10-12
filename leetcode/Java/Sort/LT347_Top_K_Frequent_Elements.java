// key point : use random pivotIdx rather than just use rightmost element
class Solution {   // 7ms 99.42% time O(n) worst O(n^2)
    int[] unique;
    HashMap<Integer, Integer> count;
    
    private void swap(int i, int j) {
        int temp = unique[i];
        unique[i] = unique[j];
        unique[j] = temp;
    }
    
    private int partition(int left, int right, int pivotIdx) {
        int pivotFreq = count.get(unique[pivotIdx]);
        swap(pivotIdx, right);
        
        int storeIdx = left;
        for (int i = left; i <= right; ++i) {
            if (count.get(unique[i]) < pivotFreq) {
                swap(storeIdx, i);
                storeIdx++;
            }
        }
        swap(storeIdx, right);
        return storeIdx;
        
    }
    
    private void quickSelect(int left, int right, int kthSmallest) {
        if (left == right) return;

        // select a random pivot_index
        // this will improve the performance 
        // better than just choose the rightmost element
        Random randomNum = new Random();
        int pivotIdx = left + randomNum.nextInt(right - left); 
        
        int pivotIdx = partition(left, right, pivotIdx);
        if (kthSmallest == pivotIdx)
            return;
        else if (kthSmallest > pivotIdx) {
            quickSelect(pivotIdx + 1, right, kthSmallest);
        } else {
            quickSelect(left, pivotIdx - 1, kthSmallest);
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int key : count.keySet()) {
            unique[i] = key;
            i++;
        }
        
        quickSelect(0, n - 1, n - k);
        
        return Arrays.copyOfRange(unique, n - k, n);
    }
    
}