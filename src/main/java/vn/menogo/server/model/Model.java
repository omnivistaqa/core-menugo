package vn.menogo.server.model;

/**
 * Created by itn0309 on 6/13/2017.
 */
public class Model<T extends Provider> {
    /**
     *
     */
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
