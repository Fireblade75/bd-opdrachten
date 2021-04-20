package com.example.jpa.books.actions;

public class ActionList {

    public static final String BUY_BOOK = "Buy book";
    public static final String VIEW_SALES = "View sales";
    public static final String UNDO_LAST_SALE = "Undo last sale";
    public static final String MODIFY_BOOK_PRICE = "Modify book price";
    public static final String EXIT = "Exit";

    public static final int BUY_BOOK_INDEX = 0;
    public static final int VIEW_SALES_INDEX = 1;
    public static final int UNDO_LAST_SALE_INDEX = 2;
    public static final int MODIFY_BOOK_PRICE_INDEX = 3;
    public static final int EXIT_INDEX = 4;

    public static final String[] ACTION_LIST = new String[5];

    static {
        ACTION_LIST[BUY_BOOK_INDEX] = BUY_BOOK;
        ACTION_LIST[VIEW_SALES_INDEX] = VIEW_SALES;
        ACTION_LIST[UNDO_LAST_SALE_INDEX] = UNDO_LAST_SALE;
        ACTION_LIST[MODIFY_BOOK_PRICE_INDEX] = MODIFY_BOOK_PRICE;
        ACTION_LIST[EXIT_INDEX] = EXIT;
    };

    public static int indexOf(String action) {
        for (int i = 0; i < ACTION_LIST.length; i++) {
            if(action.equals(ACTION_LIST[i])) return i;
        }
        return -1;
    }
}
