/**
 * Created by xichen on 2017/4/16.
 */
public class SymbolNode extends SymbolTableEntry {

    private int key;
    private SymbolNode next;

    public SymbolNode(SymbolTableEntry SymbolTableEntry, int key) {
        super(SymbolTableEntry.getIdentifier(), SymbolTableEntry.getBlockNumber());
        this.key = key;
        this.next = null;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public SymbolNode getNext() {
        return next;
    }

    public void setNext(SymbolNode next) {
        this.next = next;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof SymbolNode) {
            SymbolNode symbolNode = (SymbolNode) object;
            if (super.equals((SymbolTableEntry) symbolNode)
                    && this.getKey() == symbolNode.getKey()) return true;
        }
        return false;
    }
}
