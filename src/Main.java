import java.io.File;
import java.util.Scanner;



public class Main {
    public static final String FILE_ADDRESS = "Test.txt";
    static SymbolTable symbolTable = new SymbolTable();
    static BlockStack activeBlockStack = new BlockStack();
    static BlockStack closedBlockStack = new BlockStack();

    public static void main(String[] args) {

        //open the file and define the default value of currentBlock#.
        int currentBlockNumber = -1;
        File thisFile = new File(FILE_ADDRESS);
        Scanner thisScanner = new Scanner(thisFile);
        //use the java scanner to read the file

        try {
            //read the next word if there is.
            while (thisScanner.hasNext()) {
                String currentWord = thisScanner.next();
                //to check if the word is begin/end
                if (currentWord.trim().toUpperCase().equals("BEGIN")) {
                    currentBlockNumber++;
                    activeBlockStack.push(currentBlockNumber);
                } else if (currentWord.trim().toUpperCase().equals("END")) {
                    if (!activeBlockStack.isEmpty())
                        closedBlockStack.push(activeBlockStack.pop());
                } else {
                    //Find in local Scope
                    SymbolTableEntry currentSymbol = new SymbolTableEntry(currentWord, activeBlockStack.peek());
                    //Check whether this variable is declared in the current scope.
                    if (!currentSymbol.equals(findInCurrent(currentSymbol))) {
                        //Check whether this variable is declared in the open scope.
                        String entryFound = findInAllOpen(currentWord);
                        if (entryFound != null && !entryFound.isEmpty())
                            System.out.println(currentWord + " is declared in other open scopes" + entryFound + ".");
                        insertSymbol(currentSymbol);
                    } else {
                        System.out.println(currentWord + " is declared in the current scope #" + currentSymbol.getBlockNumber() + ".");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.out.println("An error occurs when reading the file.");
        }

        //Write the symbol table
        try {
            symbolTable.display(closedBlockStack);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.out.println("An error occurs when writing the file.");
        }
    }

    public static SymbolTableEntry findInCurrent(SymbolTableEntry symbolTableEntry) {
        return symbolTable.findSymbol(symbolTableEntry);
    }

    public static String findInAllOpen(String identifier) {
        String retStr = "";
        for (int index = activeBlockStack.getStackSize() - 1; index >= 0; index--) {
            SymbolTableEntry symbolTableEntry = symbolTable.findSymbol(new SymbolTableEntry(identifier, activeBlockStack.get(index)));
            if (symbolTableEntry != null) {
                retStr += " #" + String.valueOf(symbolTableEntry.getBlockNumber());
            }
        }
        return retStr;
    }

    public static void insertSymbol(SymbolTableEntry entryInserted) {
        symbolTable.insertSymbol(entryInserted);
    }
}


//        System.out.println("Hello World!");
