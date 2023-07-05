package myJava.code.challenges;

public class SumRowsIn2DArray {
  public int[] rowSums(int[][] inputArr) {
    if (inputArr.length <= 0) {
      return new int[0];
    }

    int[] resultArr = new int[inputArr.length];

    for (int outerIdx = 0; outerIdx < inputArr.length; outerIdx++) {
      int rowSum = 0;

      // check for a null row and skip it
      if (inputArr[outerIdx] == null) {
        continue;
      }

      int[] row = inputArr[outerIdx];

      for (int innerIdx = 0; innerIdx < row.length; innerIdx++) {
        // this code fails because primitive types cannot be null
        // int itemValue = 0;
        // if (row[innerIdx] != null) {
        // itemValue = row[innerIdx];
        // }

        int itemValue = row[innerIdx]; // long-form
        rowSum += itemValue;
      }

      // cannot access variable 'row' here
      // resultArr[row] = rowSum;
      resultArr[outerIdx] = rowSum;
    }

    return resultArr;
  }
}
