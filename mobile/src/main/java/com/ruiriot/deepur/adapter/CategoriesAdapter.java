package com.ruiriot.deepur.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample name for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CategoriesAdapter {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CategoriesItem> ITEMS = new ArrayList<CategoriesItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CategoriesItem> ITEM_MAP = new HashMap<String, CategoriesItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(CategoriesItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CategoriesItem createDummyItem(int position) {
        return new CategoriesItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore color information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of name.
     */
    public static class CategoriesItem {
        public final String id;
        public final String name;
        public final String color;
        //public final String image;

        public CategoriesItem(String id, String name, String color) {
            this.id = id;
            this.name = name;
            this.color = color;
            //this.image = image;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
