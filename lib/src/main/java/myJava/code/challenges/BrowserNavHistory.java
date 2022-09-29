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
     * @throws IndexOutOfBoundsException Checked Exception is index is corrupt
     */
    public void enhancedGo(String address) throws IndexOutOfBoundsException {
        if (this.isNotBlankInput(address)) {
            if (this.currentIdx > 0) {
                String currentAddress = this.history.get(currentIdx);
                this.history.remove(currentAddress);
                this.history.addFirst(currentAddress);
                this.history.remove(address);
            }

            this.history.addFirst(address);
            this.currentIdx = 0;
        }
    }

    private boolean isNotBlankInput(String address) {
        return address.length() >= 11 && !address.matches("\\s+");
    }

    /**
     * Returns the address one forward from current location within the history list.
     * @return String
     */
    public String forward() {
        if (this.currentIdx == 0) {
            return "";
        }
        this.currentIdx--;
        return this.history.get(currentIdx);
    }

    /**
     * Return the next address 'ahead' of the current location within the history list.
     * @return String address
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
     * @return String
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
     * @return String
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

    /**
     * Helper method returns size of internal Linked List.
     * @return int
     */
    public int getCount() {
        return history.size();
    }

    /**
     * Helper method for unit testing.
     * @param itemToFind String
     * @return boolean
     */
    public boolean contains(String itemToFind) {
        return history.contains(itemToFind);
    }

    /**
     * Helper method for unit testing.
     * @return String
     */
    public String getHead() {
        return this.history.peekFirst();
    }

    /**
     * Helper method for unit testing.
     * @return String
     */
    public String getTail() {
        return this.history.peekLast();
    }
}
