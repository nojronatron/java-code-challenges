package myJava.code.models.GenericBinaryTree;

import java.util.Objects;

public class MyBinaryNode<T> {
    // implement comparable<T>
    private final T value;
    private MyBinaryNode<T> leftChild;
    private MyBinaryNode<T> rightChild;

    public MyBinaryNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public MyBinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyBinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public MyBinaryNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyBinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.value.toString()).append(":");
        if (this.leftChild != null) {
            sb.append(this.leftChild.value.toString());
        } else {
            sb.append(" ");
        }
        sb.append(",");
        if (this.rightChild != null) {
            sb.append(this.rightChild.value.toString());
        } else {
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBinaryNode<?> that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
