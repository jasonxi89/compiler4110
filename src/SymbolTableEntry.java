/**
 * Created by xichen on 2017/4/16.
 */
public class SymbolTableEntry {
    private String identifier;
    private int blockNumber;

    public SymbolTableEntry() {
    }

    ;

    public SymbolTableEntry(String identifier, int blockNumber) {
        this.setIdentifier(identifier);
        this.setBlockNumber(blockNumber);
    }

    public String getIdentifier() {
        //The source language is not case sensitive.
        return this.identifier.toUpperCase();
    }

    public void setIdentifier(String identifier) {
        //The source language is not case sensitive.
        this.identifier = identifier.toUpperCase();
    }

    public int getBlockNumber() {
        return this.blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber < 0 ? 0 : blockNumber;
    }

    public String toString() {
        return "Symbol Table Entry: { Identifier Name = " + this.getIdentifier() + "; Block Number = " + this.getBlockNumber() + "; }";
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof SymbolTableEntry) {
            SymbolTableEntry symbolTableEntry = (SymbolTableEntry) object;
            if (symbolTableEntry.getIdentifier().equals(this.getIdentifier())
                    && symbolTableEntry.getBlockNumber() == this.getBlockNumber())
                return true;
        }
        return false;
    }



}

