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
                }

                if (currentWord.trim().toUpperCase().equals("END")) {
                    //for the end, if the there is active block, go back the previous active block, otherwise error.
                    if (!activeBlockStack.isEmpty())
                        closedBlockStack.push(activeBlockStack.pop());
                    else {
                        //Find in local Scope
                        SymbolTableEntry currentSymbol = new SymbolTableEntry(currentWord, activeBlockStack.peek());
                    }


//
                }

            }
        } ;


//        System.out.println("Hello World!");
    }
}
