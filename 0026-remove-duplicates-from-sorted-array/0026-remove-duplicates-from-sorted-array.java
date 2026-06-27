class Solution {
    public int removeDuplicates(int[] arr) {

        int n = arr.length;

        int i = 0;
        int j = 0;
        int index = 0;

        while(i < n){
            //find next unique element
            while (j < n && arr[i] == arr[j]) {
                j++;
            }

            arr[index] = arr[i];
            index++;

            i = j;
        }
        return index;
    }
}
