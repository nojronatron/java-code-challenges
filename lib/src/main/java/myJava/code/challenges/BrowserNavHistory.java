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
     * Adds the address to the front of the list and maintains the existing next address.
     * @param address String
     * @throws IndexOutOfBoundsException Checked Exception is index is corrup
     */
    public void enhancedGo(String address) throws IndexOutOfBoundsException {
        //  todo: filter-out an all spaces String input
        if (!address.equals("") && !address.equals(" ")) {
            if (this.history.contains(address)) {
                this.currentIdx = this.history.indexOf(address);
                this.history.remove(address);
            }
            if (this.currentIdx > -1) {
                String tempAddress = this.history.get(this.currentIdx);
                this.currentIdx = 0;
                this.history.add(tempAddress);
                this.history.add(address);
            } else {
                this.history.add(address);
                this.currentIdx = 0;
            }
        }
    }

    /**
     * Returns the address one forward from current location within the history list.
     * @return String
     */
    public String forward() {
        if (this.currentIdx == 0) {
            return "";  //  todo: return the first index string instead of nothing
        }
        this.currentIdx--;
        return this.history.get(currentIdx);
    }

    /**
     * Return the next address 'ahead' of the current location within the history list.
     * @return
     */
    public String enhancedForward() {
        if (this.currentIdx > 0) {
            this.currentIdx--;
            return this.history.get(this.currentIdx);
        }
        if (this.currentIdx == 0) {
            return this.history.get(this.currentIdx);
        }
        return "";
    }

    /**
     * Returns the address just previous to the currently visited address.
     * @return
     */
    public String back() {
        if (this.currentIdx >= this.getCount() - 1) {
            return "";  //  todo: return the last index string instead of nothing
        }
        this.currentIdx++;
        return this.history.get(currentIdx);
    }

    /**
     * Returns the previous address 'behind' the current location within the history list.
     * @return
     */
    public String enhancedBack() {
        if (this.history.size() > this.currentIdx + 1) {
            currentIdx++;
            return this.history.get(currentIdx);
        }
        if (this.history.size() == this.currentIdx + 1) {
            return this.history.get(this.currentIdx);
        }
        return "";
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
