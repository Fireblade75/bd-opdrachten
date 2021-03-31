package nl.firepy.mysticforest.model;

import nl.firepy.mysticforest.exceptions.InventoryFullException;
import nl.firepy.mysticforest.model.items.Item;
import nl.firepy.mysticforest.model.items.ItemStack;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
    private static final long serialVersionUID = -3924487671480923658L;
    private static final int INVENTORY_SIZE = 20;

    private final ArrayList<ItemStack> itemStacks = new ArrayList<>(INVENTORY_SIZE);

    public void addItem(Item item) {
        for(var stack : itemStacks) {
            if(stack.getItem().equals(item)) {
                stack.increment();
                return;
            }
        }

        if(itemStacks.size() > INVENTORY_SIZE) {
            throw new InventoryFullException();
        } else {
            itemStacks.add(new ItemStack(item));
        }
    }

}
