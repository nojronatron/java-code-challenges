package myJava.code.challenges;

public class InsertionSorter {
    static int[] insertionSort(int[] inputArr) {
        if (inputArr.length < 1) {
            return new int[0];
        }
        LinkedList linkedList = new LinkedList(inputArr[0]);
        int idx = 1;
        while (idx < inputArr.length) {
            linkedList.addSort(inputArr[idx]);
            idx++;
        }
        int[] resultArr = toArray(linkedList, inputArr.length);
        return resultArr;
    }

    static int[] toArray(LinkedList inputList, int size) {
        int[] resultArr = new int[size];
        int idx = 0;
        LinkedList.LLNode<Integer> current = inputList.getHead();
        while (current != null) {
            resultArr[idx] = current.getValue();
            current = current.getNext();
            idx++;
        }
        return resultArr;
    }

    protected static class LinkedList {
        private LLNode<Integer> head;

        public LinkedList(Integer value) {
            this.head = new LLNode<>(value);
        }

        public LLNode<Integer> getHead() {
            return this.head;
        }

        public void addSort(Integer inputValue) {
            LinkedList.LLNode<Integer> current = this.head;
            LinkedList.LLNode<Integer> newNode = new LinkedList.LLNode<>(inputValue);
            while (current != null) {
                if (current.equals(this.head) && inputValue.compareTo(head.value) <= 0) {
                    newNode.setNext(head);
                    this.head = newNode;
                    return;
                }
                if (current.getNext() == null) {
                    current.setNext(newNode);
                    return;
                }
                if (current.getValue().compareTo(inputValue) <= 0
                        && inputValue.compareTo(current.getNext().getValue()) < 0) {
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    return;
                }
                current = current.getNext();
            }
        }

        public static class LLNode<J extends Comparable<J>> {
            private final J value;
            private LLNode<J> next;

            public LLNode(J value) {
                this.value = value;
                this.next = null;
            }

            public J getValue() {
                return this.value;
            }

            public LLNode<J> getNext() {
                return this.next;
            }

            public void setNext(LLNode<J> nextNode) {
                this.next = nextNode;
            }

        }
    }
}
