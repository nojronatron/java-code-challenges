package myJava.code.challenges;

public class ConnectBinaryTrees<T> {
    private T value;
    private ConnectBinaryTrees<T> leftChild;
    private ConnectBinaryTrees<T> rightChild;
    public ConnectBinaryTrees(T data){
        this.value = data;
    }
    public T getValue(){
        return this.value;
    }
    public ConnectBinaryTrees<T> getLeftChild(){
        return this.leftChild;
    }
    public ConnectBinaryTrees<T> getRightChild(){
        return this.rightChild;
    }
    public void setLeftChild(ConnectBinaryTrees<T> node){
        this.leftChild = node;
    }
    public void setRightChild(ConnectBinaryTrees<T> node){
        this.rightChild = node;
    }
    public boolean isLeaf(){
        return this.leftChild == null && this.rightChild == null;
    }
    public boolean hasOnlyLeft(){
        return this.leftChild != null && this.rightChild == null;
    }
    public boolean hasOnlyRight(){
        return this.leftChild == null && this.rightChild != null;
    }
    @Override
    public String toString(){
        // this is for ease of debugging this Node instance
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.value.toString()).append(":");
        var leftItem = this.getLeftChild() != null ? this.getLeftChild().getValue() : " ";
        var rightItem = this.getRightChild() != null ? this.getRightChild().getValue() : " ";
        sb.append(leftItem.toString()).append(",").append(rightItem.toString());
        sb.append("]");
        return sb.toString();
    }
    public String displayTree(){
        // this is for ease of debugging to display list of nodes in this tree instance
        return "";
    }
    public static <T> ConnectBinaryTrees<T> addTree(ConnectBinaryTrees<T> left, ConnectBinaryTrees<T> right){
        
        return right;
    }
}
