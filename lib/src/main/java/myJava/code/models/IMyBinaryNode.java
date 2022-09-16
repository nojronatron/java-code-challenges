package myJava.code.models;

import myJava.code.models.MyBinaryNode;

public interface IMyBinaryNode {
    MyBinaryNode getLeft();

    void setLeft(MyBinaryNode left);

    MyBinaryNode getRight();

    void setRight(MyBinaryNode right);

    int getValue();
}
