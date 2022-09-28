package myJava.code.challenges;

import java.util.LinkedList;

public class BrowserNavHistory {
    private final LinkedList<String> history;
    private Integer currentIdx;
    public BrowserNavHistory() {
        this.history = new LinkedList<>();
        this.currentIdx = -1;
    }
    public void go(String address) throws IndexOutOfBoundsException {
        this.currentIdx++;
        this.history.add(currentIdx, address);
    }
    public String forward() {
        if (this.currentIdx == this.getCount() - 1) {
            return "";
        }
        this.currentIdx++;
        return this.history.get(currentIdx);
    }
    public String back() {
        if (this.currentIdx == 0) {
            return "";
        }
        this.currentIdx--;
        return this.history.get(currentIdx);
    }
    public int getCount() {
        return history.size();
    }
    public boolean contains(String itemToFind) {
        return history.contains(itemToFind);
    }
    public String getItem(String itemToGet) {
        var itemIdx = history.indexOf("");
        return history.get(itemIdx);
    }
    public String getHead() {
        return this.history.peekFirst();
    }
    public String getTail() {
        return this.history.peekLast();
    }
}
