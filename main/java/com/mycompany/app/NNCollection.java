package com.mycompany.app;

import java.util.ArrayList;

public class NNCollection {
    private ArrayList<String> collection;

    public NNCollection() {
        this.collection = new ArrayList<>();
    }

    public void addItem(String item) {
        collection.add(item);
    }

    public ArrayList<String> getItems() {
        return collection;
    }
}
