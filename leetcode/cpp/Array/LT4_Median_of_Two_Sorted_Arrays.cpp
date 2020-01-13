class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int m = nums1.size();
        int n = nums2.size();
        int total = m + n;
        int mIdx = -1;
        bool isOdd = true;
        
        if (total % 2 != 0) {
            mIdx = total / 2;
        } else {
            mIdx = (total / 2) - 1;
            isOdd = false;
        }
        
        if (nums1.empty())
            return (isOdd ? nums2[Idx]:((nums2[Idx] + nums2[Idx+1]) / 2);
        
        if (nums2.empty())
            return (isOdd ? nums1[Idx]:((nums1[Idx] + nums1[Idx+1]) / 2);         
        
        if (nums1[m-1] < nums2[0]) {
            if (isOdd) {
                return ((mIdx >= m) ? nums2[mIdx-m] : nums1[mIdx]); 
            } else {
                if (mIdx < m-1) {
                    return (nums1[mIdx] + nums1[Idx+1]) / 2;
                } else if(mIdx == m-1) {
                    return (nums1[m-1] + nums2[0]) / 2;
                } else {
                    return (nums2[Idx] + nums2[Idx+1]) / 2;
                }
            }
        }
                    
        if (nums2[n-1] < nums1[0]) {
            if (isOdd) {
                return ((mIdx >= n) ? nums1[mIdx-n] : nums2[mIdx]); 
            } else {
                if (mIdx < n-1) {
                    return (nums1[mIdx] + nums1[Idx+1]) / 2;
                } else if(mIdx == n-1) {
                    return (nums1[m-1] + nums2[0]) / 2;
                } else {
                    return (nums2[Idx] + nums2[Idx+1]) / 2;
                }
            }
        }
              
        int i=0, j=0, tmpIdx=0;
        while(tmpIdx < mIdx) {
            
            while((i < m) && (nums1[i] <= nums2[j])) {
                if (tmpIdx == mIdx) {
                    if (isOdd)
                        return nums1[i];
                    else {
                        if (i < m-1) {
                            return (nums1[i] + nums1[i+1]) / 2;
                        } else if (i == m-1) {
                            return (nums1[i] + nums2[j]) / 2;
                        } else {
                            break;
                        }
                    }
                }
                i++;
                tmpIdx++;
            }
            
            while((j < n) && (nums2[j] < nums1[i])) {
                if (tmpIdx == mIdx) {
                    if (isOdd)
                        return nums2[j];
                    else {
                        if (j < n-1) {
                            return (nums2[j] + nums2[j+1]) / 2;
                        } else if (i == n-1) {
                            return (nums2[j] + nums1[i]) / 2;
                        } else {
                            break;
                        }
                    }
                }
                j++;
                tmpIdx++;
            }
        }
                    
        
                    
        
    }
};
