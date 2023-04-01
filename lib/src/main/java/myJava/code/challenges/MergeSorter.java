package myJava.code.challenges;

public class MergeSorter {
    public void mergeSort(int[] inputArr) {
        int arrStart = 0;
        partition(arrStart, inputArr.length - 1, inputArr);
    }

    public void partition(int arrStart, int arrEnd, int[] inputArr) {
//        System.out.println("Partitioning...");
        if (arrStart == arrEnd) {
            return;
        }
//        printArray(inputArr);
        int arrStartEndDiff = arrEnd - arrStart;
        int mid = arrStartEndDiff % 2 == 0 ? arrStartEndDiff / 2 : (arrStartEndDiff + 1) / 2;
        mid += arrStart;
        int leftEnd = mid-1;
        partition(arrStart, leftEnd, inputArr);
        partition(mid, arrEnd, inputArr);
        merge(arrStart, mid, arrEnd, inputArr);
//        printArray(inputArr);
    }

    public void merge(int start, int midPoint, int end, int[] inputArr) {
//        printArray(inputArr);
        int leftIDX = start;
        int rightIDX = midPoint;
        int tempIDX = start;
        int[] tempArray = new int[inputArr.length];

        while (leftIDX < midPoint && rightIDX <= end) {
//            System.out.println("Iterating While in Merge()");
            if (inputArr[leftIDX] <= inputArr[rightIDX]) {
                tempArray[tempIDX] = inputArr[leftIDX];
                leftIDX++;
            } else {
                tempArray[tempIDX] = inputArr[rightIDX];
                rightIDX++;
            }
            tempIDX++;
        }

        for (int fillIDX=leftIDX; fillIDX < midPoint; fillIDX++) {
//            System.out.println("Iterating For1 in Merge()");
            tempArray[tempIDX] = inputArr[fillIDX];
            tempIDX++;
        }
        for (int fillIDX=rightIDX; fillIDX <= end; fillIDX++) {
//            System.out.println("Iterating For2 in Merge()");
            tempArray[tempIDX] = inputArr[fillIDX];
            tempIDX++;
        }
        //            System.out.println("Iterating For3 in Merge()");
        if (end + 1 - start >= 0) System.arraycopy(tempArray, start, inputArr, start, end + 1 - start);
    }

    private void printArray(int[] arr){
        StringBuilder result = new StringBuilder("[");
        for(int idx=0; idx< arr.length; idx++){
            result.append(arr[idx]).append(",");
        }
        result.delete(result.length() - 1, result.length());
        result.append("]");
        System.out.printf("Current array contents: %s%n", result);
    }
}
