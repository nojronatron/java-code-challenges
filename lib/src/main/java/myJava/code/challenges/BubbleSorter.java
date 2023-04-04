package myJava.code.challenges;

public class BubbleSorter {
    public static void bubbleSort(int[] inputArray){
        if (inputArray.length > 1) {
            int sortedCount = 0;
            while (sortedCount < inputArray.length - 1){
                int idx = 0;
                while(idx < inputArray.length - 1) {
                    if (inputArray[idx] > inputArray[idx+1]){
                        sortedCount = 0;
                        int tempValue = inputArray[idx];
                        inputArray[idx] = inputArray[idx+1];
                        inputArray[idx+1] = tempValue;
                    } else {
                        sortedCount++;
                    }
                    idx++;
                }
            }
        }
    }
}
