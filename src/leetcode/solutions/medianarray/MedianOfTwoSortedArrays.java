package leetcode.solutions.medianarray;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = nums1.length - 1;
        int x = 0;
        int y = nums2.length - 1;

        if (nums1.length == 0) {
            return onTheOtherArray(x, y, nums2);
        } else if (nums2.length == 0) {
            return onTheOtherArray(i, j, nums1);
        }

        if (nums1.length == 1 && nums2.length == 1) {
            return (nums1[0] + nums2[0]) / 2.0;
        }

        while (true) {
            // lower number
            if (nums1[i] < nums2[x]) {
                nums1[i] = -1;
                if (i != j) {
                    i++;
                }
            } else {
                nums2[x] = -1;
                if (x != y) {
                    x++;
                }
            }
            // greater number
            if (nums1[j] > nums2[y]) {
                nums1[j] = -1;
                if (i != j) {
                    j--;
                }
            } else {
                nums2[y] = -1;
                if (x != y) {
                    y--;
                }
            }

            // in first and seconds table is only 1 or 0 elements left
            if (i == j && x == y) {
                if (nums1[i] == -1) {
                    return nums2[x];
                } else if (nums2[x] == -1) {
                    return nums1[i];
                }
                return (nums1[i] + nums2[x]) / 2.0;
            }

            if (i == j && nums1[i] == -1) {
                return onTheOtherArray(x, y, nums2);
            }
            if (x == y && nums2[x] == -1) {
                return onTheOtherArray(i, j, nums1);
            }
        }
    }

    private double onTheOtherArray(int a, int b, int nums[]) {
        if (a == b) {
            return nums[a];
        }
        if (a + 1 == b) {
            return (nums[a] + nums[b]) / 2.0;
        }
        while (true) {
            if (a == b) {
                return nums[a];
            }
            if (a + 1 == b) {
                return (nums[a] + nums[b]) / 2.0;
            }
            a++;
            b--;

        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int nums1[] = {1, 5, 6, 7};
        int nums2[] = {1, 2, 3};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
