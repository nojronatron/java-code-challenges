package myJava.code.challenges;

import java.util.LinkedList;

public class BrowserNavHistory {
    private final LinkedList<String> history;
    private final LinkedList<String> current;
    public BrowserNavHistory() {
        this.history = new LinkedList<>();
        this.current = null;
    }
    public void go(String address) {

    }
    public String forward() {

        return "";
    }
    public String back() {

        return "";
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
