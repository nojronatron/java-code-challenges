package myJava.code.models;

import java.util.ArrayList;
import java.util.List;

public interface IMyKaryNode<T> {
  ArrayList<MyKaryNode<T>> getChildren();

  void setChildren(List<MyKaryNode<T>> children);

  boolean hasChildren();
}
