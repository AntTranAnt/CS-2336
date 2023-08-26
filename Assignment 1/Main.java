//Anthony Tran
//CS 2336.003
//Binary searches a array and returns the index(s) of the inputted key

public class Main {
    public static void main(String[] args) {
       
    }

    //returns array of the searched index
    //returns [-1, -1] if not found
    public static int[] binarySearch(int[] nums, int key) {
        //binary search for first and last index.
        //check before/after index to see if it equals key
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        int indexOne = recursiveSearchFront(nums, key, start, end);
        result[0] = indexOne;
        result[1] = recursiveSearchEnd(nums, key, indexOne, end);
        return result;
    }

    //method binary searches the array for the first index of key
    //If mid is equal to key but not first index, same statement call
    //as mid < key
    private static int recursiveSearchFront(int[] nums, int key, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (nums[mid] == key) { //if mid is the key
            if ((mid != 0) && (nums[mid - 1] == key)) { //if key isnt the first index
                return recursiveSearchFront(nums, key, start, mid - 1);
            }
            return mid;
        } else if (nums[mid] < key) { //if mid is lower than key
            return recursiveSearchFront(nums, key, mid + 1, end);
        } else if (nums[mid] > key) { //if mid is higher than key
            return recursiveSearchFront(nums, key, start, mid - 1);
        }
        return -1;
    }

    //recursively linear search to find the end of the index
    private static int recursiveSearchEnd(int[] nums, int key, int index, int end) {
        int next = index + 1;
        if (next <= end && nums[next] == key) {
            return recursiveSearchEnd(nums, key, index + 1, end);
        }
        return index;
    }
}