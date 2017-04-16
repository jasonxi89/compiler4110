import java.io.File;
import java.util.Scanner;


public class Main {
    public static final String FILE_ADDRESS = "Test.txt";
    static SymbolTable symbolTable = new SymbolTable();
    static BlockStack activeBlockStack = new BlockStack();
    static BlockStack closedBlockStack = new BlockStack();

    public static void main(String[] args) {

        int currentBlockNumber = -1;
        File thisFile = new File(FILE_ADDRESS);
        Scanner thisScanner = new Scanner(thisFile);
        try {
            while (thisScanner.hasNext()) {
                String currentWord = thisScanner.next();
                if (currentWord.trim().toUpperCase().equals("BEGIN")) {
                    currentBlockNumber++;
                    activeBlockStack.push(currentBlockNumber);

                }
                if (currentWord.trim().toUpperCase().equals("END")) {
//                        currentBlockNumber-=1;
                }

            }
        } ;


//        System.out.println("Hello World!");
    }
}
