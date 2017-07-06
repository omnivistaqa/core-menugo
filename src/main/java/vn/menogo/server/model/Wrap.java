package vn.menogo.server.model;

import java.util.List;

/**
 * Created by itn0309 on 6/28/2017.
 */
public class Wrap<T> {
    private T items ;
    public Wrap(T items) {
        this.items = items;
    }

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

}
