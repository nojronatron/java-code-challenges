package myJava.code.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestConnectBinaryTrees {
    @Test
    public void test_CanInstantiateTrees() {
        ConnectBinaryTrees<Integer> sutLeft = new ConnectBinaryTrees<>(1);
        ConnectBinaryTrees<String> sutRight = new ConnectBinaryTrees<>("right");
        assertNotNull(sutLeft);
        assertNotNull(sutRight);
    }
    @Test
    public void test_LeftTreeNullReturnsRightTree() {
        ConnectBinaryTrees<String> sutRight = new ConnectBinaryTrees<>("right");
        var result = ConnectBinaryTrees.addTree(null, sutRight);
        assertEquals("[right: , ]", result.toString());
    }
    @Test
    public void test_RightTreeNullReturnsLeftTree(){
        ConnectBinaryTrees<String> sutLeft = new ConnectBinaryTrees<>("left");
        var result = ConnectBinaryTrees.addTree(sutLeft, null);
        assertEquals("[left: , ]", result.toString());
    }
    @Test
    public void test_LeftAndRightHaveSixRightMissingRightChild(){
        var sutLeft = new ConnectBinaryTrees<>(1);
        var three = new ConnectBinaryTrees<>(3);
        var five = new ConnectBinaryTrees<>(5);
        var seven = new ConnectBinaryTrees<>(7);
        var nine = new ConnectBinaryTrees<>(9);
        var eleven = new ConnectBinaryTrees<>(11);
        sutLeft.setLeftChild(three);
        sutLeft.setRightChild(five);
        three.setLeftChild(seven);
        three.setRightChild(nine);
        five.setLeftChild(eleven);
        System.out.printf("sutLeft: %s%n", sutLeft.displayTree());

        var sutRight = new ConnectBinaryTrees<>(2);
        var four = new ConnectBinaryTrees<>(4);
        var six = new ConnectBinaryTrees<>(6);
        var eight = new ConnectBinaryTrees<>(8);
        var ten = new ConnectBinaryTrees<>(10);
        var twelve = new ConnectBinaryTrees<>(12);
        sutRight.setLeftChild(four);
        sutRight.setRightChild(six);
        four.setLeftChild(eight);
        four.setRightChild(ten);
        six.setLeftChild(twelve);
        System.out.printf("sutRight: %s%n", sutRight.displayTree());

        ConnectBinaryTrees.addTree(sutLeft, sutRight);
        System.out.printf("sutLeft: %s%n", sutLeft.displayTree());
        System.out.printf("sutRight: %s%n", sutRight.displayTree());


    }
    @Test
    public void test_LeftAndRightHaveSixRightMissingLeftChild(){
        var sutLeft = new ConnectBinaryTrees<>("sutLeft");
        var three = new ConnectBinaryTrees<>("three");
        var five = new ConnectBinaryTrees<>("five");
        var seven = new ConnectBinaryTrees<>("seven");
        var nine = new ConnectBinaryTrees<>("nine");
        var eleven = new ConnectBinaryTrees<>("eleven");
        sutLeft.setLeftChild(three);
        sutLeft.setRightChild(five);
        three.setLeftChild(seven);
        three.setRightChild(nine);
        five.setRightChild(eleven);
        System.out.printf("sutLeft: %s%n", sutLeft.displayTree());

        var sutRight = new ConnectBinaryTrees<>("sutRight");
        var four = new ConnectBinaryTrees<>("four");
        var six = new ConnectBinaryTrees<>("six");
        var eight = new ConnectBinaryTrees<>("eight");
        var ten = new ConnectBinaryTrees<>("ten");
        var twelve = new ConnectBinaryTrees<>("twelve");
        sutRight.setLeftChild(four);
        sutRight.setRightChild(six);
        four.setLeftChild(eight);
        four.setRightChild(ten);
        six.setRightChild(twelve);
        System.out.printf("sutRight: %s%n", sutRight.displayTree());

        ConnectBinaryTrees.addTree(sutLeft, sutRight);
        System.out.printf("sutLeft: %s%n", sutLeft.displayTree());
        System.out.printf("sutRight: %s%n", sutRight.displayTree());

    }
    @Test
    public void test_LeftTreeAddedToLeafInRightTreeWithSeven(){
        var sutLeft = new ConnectBinaryTrees<>(1);
        var three = new ConnectBinaryTrees<>(3);
        var five = new ConnectBinaryTrees<>(5);
        var seven = new ConnectBinaryTrees<>(7);
        var nine = new ConnectBinaryTrees<>(9);
        var eleven = new ConnectBinaryTrees<>(11);
        var thirteen = new ConnectBinaryTrees<>(13);
        sutLeft.setLeftChild(three);
        sutLeft.setRightChild(five);
        three.setLeftChild(seven);
        three.setRightChild(nine);
        five.setLeftChild(eleven);
        five.setRightChild(thirteen);
        System.out.printf("sutLeft: %s%n", sutLeft.displayTree());

        var sutRight = new ConnectBinaryTrees<>(2);
        var four = new ConnectBinaryTrees<>(4);
        var six = new ConnectBinaryTrees<>(6);
        var eight = new ConnectBinaryTrees<>(8);
        var ten = new ConnectBinaryTrees<>(10);
        var twelve = new ConnectBinaryTrees<>(12);
        var fourteen = new ConnectBinaryTrees<>(14);
        sutRight.setLeftChild(four);
        sutRight.setRightChild(six);
        four.setLeftChild(eight);
        four.setRightChild(ten);
        six.setLeftChild(twelve);
        six.setRightChild(fourteen);
        System.out.printf("sutRight: %s%n", sutRight.displayTree());

        ConnectBinaryTrees.addTree(sutLeft, sutRight);
        System.out.printf("sutLeft: %s%n", sutLeft.displayTree());
        System.out.printf("sutRight: %s%n", sutRight.displayTree());


    }
}
