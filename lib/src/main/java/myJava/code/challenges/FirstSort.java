package myJava.code.challenges;

public class FirstSort {
    public static void firstSort(int[] intArr) {
        if (intArr.length == 0) {
            return;
        }
        for (int leftIdx = 0; leftIdx < intArr.length - 1; leftIdx++) {
            for (int rightIdx = leftIdx+1; rightIdx < intArr.length; rightIdx++) {
                if (intArr[leftIdx] > intArr[rightIdx]) {
                    int tempValue = intArr[leftIdx];
                    intArr[leftIdx] = intArr[rightIdx];
                    intArr[rightIdx] = tempValue;
                }
            }
        }
    }
}
