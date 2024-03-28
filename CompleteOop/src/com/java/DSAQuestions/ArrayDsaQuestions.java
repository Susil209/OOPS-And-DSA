package com.java.DSAQuestions;

import java.util.*;

public class ArrayDsaQuestions {
    //https://leetcode.com/problems/sort-colors/description/
    //Sort Colors
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // Best Time to Buy and Sell Stock
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;
        int maxProfit = 0, minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else {
                minPrice = Math.min(minPrice, prices[i]);
            }
        }

        return maxProfit;
    }

    // pair sum
    // https://www.codingninjas.com/studio/problems/pair-sum_1171154?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM

    public static int pairSum(int[] arr, int n, int target) {

        //Approach-1 (Brute Force)
        //  Time complexity: O(N ^ 2)
        //	Space complexity: O(1)

        /*
        int count = 0;
        for (int i=0 ;i < n;i++){
            for (int j=i+1; j<n ;j++){
                if(arr[i] + arr[j] == target){
                    System.out.printf("Pairs = {%d,%d} %n",arr[i],arr[j]);
                    count++;
                }
            }
        }



        return count > 0 ? count : -1;
         */

        // Approach-2 (hashing)
        //  Time complexity: O(N)
        //	Space complexity: O(N)

        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int more_needed = target - arr[i];

            if (mp.containsKey(more_needed)) {
                count++;
                System.out.printf("Pairs = {%d,%d} %n", mp.get(more_needed), i);
            } else {
                mp.put(arr[i], i);
            }

        }
        return count > 0 ? count : -1;

        // Approach-3(Two pointer)
        //  Time complexity: O(N)
        //	Space complexity: O(1)

        /*
        Arrays.sort(arr);

        int low=0;
        int high=n-1;
        int count = 0;

        while(low < high){
            if(arr[low]+arr[high]==target){
                System.out.printf("Pairs = {%d,%d} %n",arr[low],arr[high]);
                count++;
                low++;
                high--;
            }else if(arr[low]+arr[high] > target){
                high--;
            }else{
                low++;
            }
        }

        if(count>0) return count;
        else return -1;

         */

    }


    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
    // Check if Array Is Sorted and Rotated
    // TC = O(n), SC = O(1)
    public static boolean check(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                peak++;
            }
        }

        return peak <= 1;
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//    Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {

        // Approach-1 (Two pointer method)
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }

        }

        return j;
    }


    public static int[] twoSum(int[] nums, int target) {
        // Approach-1 (Brute force)

        /*
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]+nums[j] == target){
                    ans.add(i);
                    ans.add(j);
                }
            }
        }
        //convert a List<Integer> to int[] in Java
        return ans.stream().mapToInt(Integer::intValue).toArray();


         */

        // Approach-2 : (Hashing using map)
        // TC: O(n) , SC = O(n)

        /*
        Map<Integer,Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int more_needed = target - nums[i];

            if(mp.containsKey(more_needed)) {
                return new int[]{mp.get(more_needed) , i};
            }else {
                mp.put(nums[i], i);
            }
        }



        return new int[]{-1,-1};


         */


        // -------------------------------------------------------

        int left = 0;
        int right = nums.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (left <= right) {
            if (map.containsKey(target - nums[left]))
                return new int[]{left, map.get(target - nums[left])};

            map.put(nums[left], left);

            if (map.containsKey(target - nums[right]))
                return new int[]{right, map.get(target - nums[right])};

            map.put(nums[right], right);

            left++;
            right--;
        }

        return null;

    }

//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    public static int romanToInt(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 &&
                    mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
                ans -= mp.get(s.charAt(i));
            } else {
                ans += mp.get(s.charAt(i));
            }
        }

        return ans;
    }

    // Left Rotate an Array by One

    static int[] leftRotateArrayByOne(int[] arr, int n) {

        // Approach-1 ( Brute force)
        // TC = O(n), SC=O(1)


        int first = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = first;

        return arr;


    }

    // Left Rotate an Array by k elements

    public static void leftRotateBy(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);

    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Right rotate by one

    static int[] rightRotateArrayByOne(int[] arr, int n) {

        // Approach-1 ( Brute force)
        // TC = O(n), SC=O(1)


        int last = arr[n - 1];
        for (int i = 0; i < n - 2; i++) {
            arr[i + 1] = arr[i];
        }
        arr[n - 1] = last;

        return arr;
    }

//    https://leetcode.com/problems/rotate-array/description/

    // Right rotate by k elements
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }


//    https://leetcode.com/problems/move-zeroes/
//Move Zeroes

    public static void moveZeroes(int[] a) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
    }


    // Rearrange Array Elements by Sign
//    Variety-1


    // https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

    public static int[] rearrangeArray(int[] nums) {

        //Approach-1 (Brute Force)
        //Time Complexity: O(N+N/2)
//        Space Complexity:  O(N/2 + N/2) = O(N)
        /*
        int[] positive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];

        int positiveIdx = 0;
        int negativeIdx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0) negative[negativeIdx++] = nums[i];
            else positive[positiveIdx++] = nums[i];
        }

        for(int i=0;i<nums.length/2;i++){
            nums[2*i] = positive[i];
            nums[2*i+1] = negative[i];
        }
        return nums;
         */


        // Approach-2 (Using two pointer)
        // Time complexity : O(n)
        // Space Complexity : O(n)

        int posIndex = 0;
        int negIndex = 1;
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;


    }

    // Rearrange Array Elements by Sign
//    Variety-2 (Extra elements positioned at last)
    /*
    Input:  arr[] = {1,2,-4,-5,3,4}, N = 6
    Output: 1 -4 2 -5 3 4

    Explanation:
        Positive elements = 1,2
        Negative elements = -4,-5
        To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
        Leftover positive elements are 3 and 4 which are then placed at the end of the array.
     */

    public static int[] rearrangeArray2(int[] nums) {
        /*
        Time Complexity: O(2*N)
        {The worst case complexity is O(2*N) which is a combination of O(N) of traversing
         the array to segregate into neg and pos array and O(N) for adding the elements
         alternatively to the main array}.

        Explanation: The second O(N) is a combination of O(min(pos, neg)) + O(leftover elements).
         There can be two cases: when only positive or only negative elements are present,
         O(min(pos, neg)) + O(leftover) = O(0) + O(N), and when equal no. of positive and negative elements
         are present, O(min(pos, neg)) + O(leftover) = O(N/2) + O(0). So, from these two cases,
         we can say the worst-case time complexity is O(N) for the second part, and by adding
         the first part we get the total complexity of O(2*N).

         Space Complexity:  O(N/2 + N/2) = O(N)
         { N/2 space required for each of the positive and negative element arrays,
          where N = size of the array A}.
         */

        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                nums[index] = neg.get(i);
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                nums[index] = pos.get(i);
                index++;
            }
        }

        return nums;
    }


    //Next Permutation
    //https://leetcode.com/problems/next-permutation/description/

    public static void nextPermutation(int[] nums) {
        int ind1 = -1;
        int ind2 = -1;
        // step 1 find breaking point
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }
        // if there is no breaking  point
        if (ind1 == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // step 2 find next greater element and swap with ind2
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[ind1]) {
                    ind2 = i;
                    break;
                }
            }

            swap(nums, ind1, ind2);
            // step 3 reverse the rest right half
            reverse(nums, ind1 + 1, nums.length - 1);
        }
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

//    public void reverse(int[] A, int i, int j) {
//        while(i < j) swap(A, i++, j--);
//    }





//    Leaders in an Array
//    https://www.codingninjas.com/studio/problems/superior-elements_6783446?leftPanelTabValue=PROBLEM
    public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {

        //Approach-1(Brute force)
        // Time Complexity: O(N^2) , Space Complexity: O(N)

        /*
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean leader = true;

            //Checking whether arr[i] is greater than all
            //the elements in its right side
            for (int j = i + 1; j < n; j++)
                if (arr[j] > arr[i]) {

                    // If any element found is greater than current leader
                    // curr element is not the leader.
                    leader = false;
                    break;
                }

            // Push all the leaders in ans array.
            if (leader)
                ans.add(arr[i]);

        }

        return ans;
         */

        //Approach-2(Optimal solution)
        //Time Complexity: O(N) ,Space Complexity: O(N)

        ArrayList<Integer> leaders = new ArrayList<>();
//        int n= arr.length;

        int maximum = Integer.MIN_VALUE;

        for (int i=n-1; i>=0; i--) {
            if(arr[i] > maximum) {
                maximum = arr[i];
                leaders.add(arr[i]);
            }
        }

        Collections.reverse(leaders);
        return leaders;



    }
//

    // Longest Successive Elements
    //https://www.codingninjas.com/studio/problems/longest-successive-elements_6811740?leftPanelTabValue=PROBLEM&count=25&page=2&search=&sort_entity=order&sort_order=ASC


    public static int longestSuccessiveElements(int []a) {
        // Approach-1(Brute Force)
        // TC = O(N^2), SC = O(1)

        /*
        int longestLength = 1;
        int n = a.length;
          //pick a element and search for its
        //consecutive numbers:
        for (int i = 0; i < n; i++) {
            int x = a[i];
            int count=1;
            //search for consecutive numbers
            //using linear search:
            while(linearSearch(a, x + 1)){
                x = x+1;
                count = count+1;
            }

            longestLength = Integer.max(longestLength,count);
        }

        return longestLength;

         */


        // Approach-3(Using Set)
        // Time Complexity : O(N) + O(2*N) ~ O(3*N) , Space Complexity: O(N)

        // For HashSet, LinkedHashSet, and EnumSet,
        // the add(), remove() and contains() operations cost constant O(1) time
        // thanks to the internal HashMap implementation.

        //Likewise, the TreeSet has O(log(n)) time complexity

        int longestLength = 1;
        Set<Integer> st = new HashSet<>();
        int n = a.length;

        // copy all arr elements into set
        for(int i=0; i<n ;i++) {
            st.add(a[i]);
        }


        // loop in each set ele

        for(int it: st){
            // check 'it' is the first ele
            if(!st.contains(it-1)) {
                int count = 1;
                int x = it;

                // search for next consecutive ele
                while (st.contains(x+1)) {
                    x = x + 1;
                    count = count + 1;
                }

                // update the longest length
                longestLength = Math.max(count, longestLength);
            }
        }


        return longestLength;




        /*
        Arrays.sort(a);

        int n=a.length;
        int lastSmaller = Integer.MIN_VALUE;
        int count=0;
        int longestLength = 1;

        for(int i=0 ;i<n; i++){
            if(a[i]-1 == lastSmaller){
                count = count+1;
                lastSmaller = a[i];
            }

            else if(lastSmaller != a[i]){
                count = 1;
                lastSmaller = a[i];
            }

            longestLength = Math.max(longestLength,count);
        }


        return longestLength;
        */


    }

    public static boolean linearSearch(int []a, int num) {
        int n = a.length; //size of array
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }




    public static void main(String[] args) {

        // Check if Array Is Sorted and Rotated

//        int[] num = {5, 4, 1, 2, 3};
//        System.out.println(a.check(num));


//    Remove Duplicates from Sorted Array

//        int[] nums = {1, 1, 2, 2, 3}; // Input array
//        // int[] expectedNums = {1, 2, 3}; // The expected answer with correct length
//
//        int k = removeDuplicates(nums); // Calls your implementation
//
//        System.out.println(k);

//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//            assert nums[i] == expectedNums[i];
//        }

//        Two Sum

//        int[] nums = {2,6,5,8,11};
//        int target = 14;
//
//        int[] ans = twoSum(nums,target);
//
//        System.out.println(Arrays.toString(ans));

        // Roman to integer

//        String s = "LVIII";
//        System.out.println(romanToInt(s));

        // Left Rotate an Array by One
//        int[] arr = {1,2,3,4,5};
//        System.out.println(Arrays.toString(leftRotateArrayByOne(arr, 5)));

        // LEFT ROTATE BY K ELEMENTS
//        int[] arr = {1,2,3,4,5,6};
//        leftRotateBy(arr,3);
//        System.out.println(Arrays.toString(arr));

        // move zeros
//        int[] arr = {1,0,2,0,3,6,0};
//        moveZeroes(arr);
//        System.out.println(Arrays.toString(arr));

        //pair sum
//        int[] arr = {1,2,3,4,5};
//        int countOfPairs = pairSum(arr,arr.length,5);
//        System.out.println("No of pairs = "+ countOfPairs);

        // buy and sell stock
//        int[] arr = {7,1,5,3,6,4};
//        System.out.println("Maximum profit = "+ maxProfit(arr));

        //Rearrange acc to sign
        // variety-1
//        int[] arr = {3,1,-2,-5,2,-4};
//        int[] ans = rearrangeArray(arr);
//        for (int i: ans) {
//            System.out.print(i + ",");
//        }

        // variety-2
//        int[] arr = {1,2,-3,-1,-2,-3};
//        int[] ans = rearrangeArray2(arr);
//        for (int i: ans) {
//            System.out.print(i + ",");
//        }

        // Next permutation
//        int[] arr = {3, 1, 2};
//        nextPermutation(arr);
//        for (int n : arr) {
//            System.out.print(n + ",");
//        }


        //Leaders in an array
//        int n = 6;
//        int[] arr=  {10, 22, 12, 3, 0, 6};
//
//
//        ArrayList<Integer> ans= printLeadersBruteForce(arr,n);
//
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.print(ans.get(i)+" ");
//        }

        // longest consecutive
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}


