package myJava.code.models;

public interface IMyBinaryNode {
  MyBinaryNode getLeft();

  void setLeft(MyBinaryNode left);

  MyBinaryNode getRight();

  void setRight(MyBinaryNode right);

  int getValue();
}
