package myJava.code.challenges;

import java.util.LinkedList;

public class BrowserNavHistory {
    private final LinkedList<String> history;
    private Integer currentIdx;
    public BrowserNavHistory() {
        this.history = new LinkedList<>();
        this.currentIdx = -1;
    }

    /**
     * Adds a new History address to the front of the list.
     * @param address String
     * @throws IndexOutOfBoundsException Checked Exception if index is corrupt
     */
    public void go(String address) throws IndexOutOfBoundsException {
        if (this.currentIdx < 0) {
            this.currentIdx = 0;
        }
        this.history.add(currentIdx, address);
    }

    /**
     * Returns the address one forward from current location, within the history list.
     * @return String
     */
    public String forward() {
        if (this.currentIdx == 0) {
            return "";  //  todo: return the first index string instead of nothing
        }
        this.currentIdx++;
        return this.history.get(currentIdx);
    }

    /**
     * Returns the address just previous to the currently visited address.
     * @return
     */
    public String back() {
        if (this.currentIdx >= this.getCount() - 1) {
            return "";  //  todo: return the last index string instead of nothing
        }
        this.currentIdx--;
        return this.history.get(currentIdx);
    }

    // Helper Methods
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
