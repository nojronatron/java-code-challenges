package myJava.code.challenges;

public class MergeSorter {
    public void mergeSort(int[] inputArr) {
        int arrStart = 0;
        partition(arrStart, inputArr.length - 1, inputArr);
    }

    public void partition(int arrStart, int arrEnd, int[] inputArr) {
        if (arrStart == arrEnd) {
            return;
        }
        int arrStartEndDiff = arrEnd - arrStart;
        int mid = arrStartEndDiff % 2 == 0 ? arrStartEndDiff / 2 : (arrStartEndDiff + 1) / 2;
        mid += arrStart;
        int leftEnd = mid-1;
        partition(arrStart, leftEnd, inputArr);
        partition(mid, arrEnd, inputArr);
        merge(arrStart, mid, arrEnd, inputArr);
    }

    public void merge(int leftStart, int midPoint, int rightEnd, int[] inputArr) {
        for (int leftIdx=leftStart; leftIdx <= rightEnd; leftIdx++){
            for (int rightIdx = leftIdx+1; rightIdx <= rightEnd; rightIdx++) {
                if (inputArr[leftIdx] > inputArr[rightIdx]){
                    shift(leftIdx, rightIdx, inputArr);
                }
            }
        }
    }

    public void shift(int leftIdx, int rightIdx, int[] inputArr) {
        int rIdx = rightIdx;
        while (inputArr[leftIdx] > inputArr[rIdx]) {
            int temp = inputArr[rIdx];
            inputArr[rIdx] = inputArr[rIdx - 1];
            inputArr[rIdx - 1] = temp;
            rIdx--;
        }
    }
}
