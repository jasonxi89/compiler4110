import java.util.Stack;

/**
 * Created by xichen on 2017/4/16.
 */
public class BlockStack {

    private Stack<Integer> blocks = new Stack<Integer>();
    private int stackSize = 0;

    public boolean isEmpty() {
        return this.blocks.isEmpty();
    }

    public int peek() {
        return this.blocks.peek();
    }

    public int pop() {
        this.stackSize--;
        return this.blocks.pop();
    }

    public void push(int blockNumber) {
        this.stackSize++;
        this.blocks.push(blockNumber);
    }

    public int get(int index) {
        return this.blocks.get(index);
    }

    public int getStackSize() {
        return this.stackSize;
    }


}
