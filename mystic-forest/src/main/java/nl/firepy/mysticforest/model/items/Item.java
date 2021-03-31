package nl.firepy.mysticforest.model.items;

import java.io.Serializable;

public abstract class Item implements Serializable {

    public abstract String getName();

    public abstract ItemType getType();
}
