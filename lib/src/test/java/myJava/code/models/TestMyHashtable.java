package myJava.code.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyHashtable {
    @Test
    void test_CanInstantiateMyHashtableEmpty() {
        MyHashtable sut = new MyHashtable();
        assertNotNull(sut);
    }

    @Test
    void test_PredictableHashingFunction() {

    }

    @Test
    void test_BackingArrayIsLoadedWithEmptyLinkedListBucketsUponInstantiation() {

    }

    @Test
    void test_CollisionCausesAddedValueToBeAddedToBucket() {

    }

    @Test
    void test_SetFunctionWithUniqueKeyValuePairIncreasesBackingArraySize() {

    }

    @Test
    void test_BucketsHoldKeyAndValueAsTheirData() {

    }

    @Test
    void test_GetFindsExistingKeyValuePair() {

    }

    @Test
    void test_GetReturnsNullIfKeyNotStoredInHashtable() {

    }

    @Test
    void test_HasMethodReturnsBooleanTrueIfExistsFalseIfNotInHashtable() {

    }

    @Test
    void test_GetKeysReturnsAllUniqueKeysOrNullIfNone() {

    }
}
