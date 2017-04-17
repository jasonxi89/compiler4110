/**
 * Created by xichen on 2017/4/16.
 */
public class SymbolTable {

    private final static int TABLE_SIZE = 13;
    SymbolNode[] symbolTable;

    //Initialize the entries of SymbolTable
    public SymbolTable() {
        symbolTable = new SymbolNode[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            symbolTable[i] = null;
        }
    }

    //Find the symbol from symbol table and chained linked list
    public SymbolTableEntry findSymbol(SymbolTableEntry symbolTableEntry) {
        int hash = Integer.valueOf(symbolTableEntry.getIdentifier().charAt(0)) % TABLE_SIZE;
        SymbolNode retEntry = null;
        if (symbolTable[hash] != null) {
            retEntry = symbolTable[hash];
            while (retEntry != null && !symbolTableEntry.equals(retEntry))
                retEntry = retEntry.getNext();
        }
        return retEntry;
    }

    //Insert the symbol to symbol table or chained linked list
    public void insertSymbol(SymbolTableEntry entryInserted) {
        int hash = Integer.valueOf(entryInserted.getIdentifier().charAt(0)) % TABLE_SIZE;
        if (symbolTable[hash] == null) {
            symbolTable[hash] = new SymbolNode(entryInserted, hash);
        } else {
            //New symbol is put at the head of linked list.
            SymbolNode newSymbol = new SymbolNode(entryInserted, hash);
            newSymbol.setNext(symbolTable[hash]);
            symbolTable[hash] = newSymbol;
        }
    }

    public void display(BlockStack blockStack) {
        System.out.println("Symbol Table:");
        System.out.println(this.displaySymbolTable());
        //Display all the scopes
        System.out.println("Blocks:");
        while (blockStack != null && !blockStack.isEmpty()) {
            System.out.println(this.displayByBlockNumber(blockStack.pop()));
        }
    }

    //Display all the symbol in symbol table
    public String displaySymbolTable() {
        String string = "";
        SymbolNode entry = null;

        for (int i = 0; i < TABLE_SIZE; i++) {
            string += "Chained linked list:" + i + "\n";
            if (symbolTable[i] != null) {
                entry = symbolTable[i];
                while (entry != null) {
                    string += entry.toString() + "\n";
                    entry = entry.getNext();
                }
            }
        }
        return string;
    }

    public String displayByBlockNumber(int blockNumber) {
        String string = "";
        SymbolNode entry = null;

        string += "Block Number:" + blockNumber + "\n";
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (symbolTable[i] != null) {
                entry = symbolTable[i];
                while (entry != null) {
                    if (entry.getBlockNumber() == blockNumber) {
                        string += entry.toString() + "\n";
                    }
                    entry = entry.getNext();
                }
            }
        }
        return string;
    }
}
