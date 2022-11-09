package myJava.code.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestMyGraph {
    @Test void test_CanInstantiateMyGraphClass() {
        MyGraph sut = new MyGraph();
        assertNotNull(sut);
    }
}
