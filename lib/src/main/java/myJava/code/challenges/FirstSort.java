package myJava.code.challenges;

public class FirstSort {
    public static int[] firstSort(int[] intArr) {
        if (intArr.length < 2) {
            return intArr;
        }
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            int leftIdx = 0;
            int rightIdx = 1;
            while(rightIdx < intArr.length){
                System.out.printf("leftIdx is %s.%n", leftIdx);
                if (intArr[leftIdx] > intArr[rightIdx]){
                    int tempValue = intArr[leftIdx];
                    intArr[leftIdx] = intArr[rightIdx];
                    intArr[rightIdx] = tempValue;
                    isSorted = false;
                }
                leftIdx++;
                rightIdx++;
            }
        }
        return intArr;
    }
}
