package myJava.code.challenges;

import java.util.ArrayList;

public class LargestPossibleProductStack {
  public int LargestProduct(ArrayList<Integer> collection) {
    if (collection.size() < 1) {
      return 0;
    }
    if (collection.size() == 1) {
      return collection.get(0);
    }
    LPStack<Integer> myStackOne = new LPStack<>();
    LPStack<Integer> myStackTwo = new LPStack<>();
    LPStack<Integer> myStackThree = new LPStack<>();

    for (int currentItem : collection) {
      if (currentItem == 0) {
        continue;
      }
      if (myStackOne.isEmpty()) {
        myStackOne.push(currentItem);
        continue;
      }
      if (myStackTwo.isEmpty()) {
        myStackTwo.push(currentItem);
        continue;
      }
      if (myStackThree.isEmpty()) {
        myStackThree.push(currentItem);
        continue;
      }
      int thisItem = stackSorter(myStackOne, currentItem);
      thisItem = stackSorter(myStackTwo, thisItem);
      stackSorter(myStackThree, thisItem);
    }

    int result = 1;
    if (!myStackOne.isEmpty()) {
      result *= myStackOne.peek();
    }
    if (!myStackTwo.isEmpty()) {
      result *= myStackTwo.peek();
    }
    if (!myStackThree.isEmpty()) {
      result *= myStackThree.peek();
    }
    return result;
  }

  private int stackSorter(LPStack<Integer> stack, int currentValue) {
    if (currentValue > stack.peek()) {
      int tempValue = stack.pop();
      stack.push(currentValue);
      return tempValue;
    }
    return currentValue;
  }

  private static class LPStack<T> {
    private StackNode<T> top;
    private StackNode<T> bottom;

    public LPStack() {
      this.top = null;
      this.bottom = null;
    }

    public void push(T data) {
      StackNode<T> newNode = new StackNode<>(data);
      if (this.bottom != this.top) {
        newNode.setNext(this.top);
        this.top = newNode;
      }
      if (this.bottom == this.top && !this.isEmpty()) {
        this.top = newNode;
        this.top.setNext(this.bottom);
      }
      if (this.isEmpty()) {
        this.top = newNode;
        this.bottom = newNode;
      }
    }

    public T pop() throws NullPointerException {
      StackNode<T> tempNode = this.top;
      if (this.top == this.bottom) {
        this.bottom = null;
        this.top = null;
      } else if (this.top.getNext() == this.bottom.getValue()) {
        this.top = null;
        this.top = this.bottom;
      } else {
        this.top = top.getNext();
      }
      return tempNode.getValue();
    }

    public T peek() throws NullPointerException {
      return this.top.getValue();
    }

    public boolean isEmpty() {
      return this.top == null;
    }

    private static class StackNode<T> {
      private T value;
      private StackNode<T> next;

      StackNode(T data) {
        this.value = data;
      }

      public T getValue() {
        return this.value;
      }

      public StackNode<T> getNext() {
        return next;
      }

      public void setNext(StackNode<T> next) {
        this.next = next;
      }
    }
  }
}
