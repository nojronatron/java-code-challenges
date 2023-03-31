package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMergeSorter {
    @Test public void test_goldenPath(){
        var sut = new int[]{ 15, 5, -5, 0, 20, -10, 10};
        var sorter = new MergeSorter();
        var expectedResult = new int[]{-10, -5, 0, 5, 10, 15, 20};
        sorter.mergeSort(sut);
        assertArrayEquals(expectedResult, sut);
    }
}
