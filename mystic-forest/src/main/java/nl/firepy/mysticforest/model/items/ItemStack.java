package nl.firepy.mysticforest.model.items;

import nl.firepy.mysticforest.exceptions.MaxStackSizeException;

public class ItemStack {
    private final int MAX_STACK_SIZE = 999;
    private final Item item;
    private int size;

    public ItemStack(Item item) {
        this(item, 1);
    }

    public ItemStack(Item item, int size) {
        this.item = item;
        this.size = size;
    }

    public Item getItem() {
        return item;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void increment() {
        if(size < MAX_STACK_SIZE) {
            size++;
        } else {
            throw new MaxStackSizeException();
        }
    }
}
