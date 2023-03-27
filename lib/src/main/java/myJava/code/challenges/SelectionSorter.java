package myJava.code.challenges;

public class SelectionSorter {
    public static void selectionSort(int[] inputArr) {
        if (inputArr.length < 2) {
            return;
        }
        int minValIndex = 0;
        for (int iterIndex = 0; iterIndex < inputArr.length - 1; iterIndex++) {
            minValIndex = iterIndex;
            for (int currentIndex = iterIndex + 1; currentIndex < inputArr.length; currentIndex++) {
                if (inputArr[currentIndex] < inputArr[minValIndex]) {
                    minValIndex = currentIndex;
                }
            }

            if (iterIndex != minValIndex) {
                int minVal = inputArr[minValIndex];
                inputArr[minValIndex] = inputArr[iterIndex];
                inputArr[iterIndex] = minVal;
            }
        }
    }
}
