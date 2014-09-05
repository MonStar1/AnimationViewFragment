package animviewfragment.android.epam.com.animationviewfragment;

import android.view.View;

import java.io.Serializable;


public class SerializableView implements Serializable {

    private int left;
    private int top;
    private int right;
    private int bottom;
    private int width;
    private int height;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static SerializableView create(View view) {
        SerializableView serializableView = new SerializableView();
        serializableView.setBottom(view.getBottom());
        serializableView.setTop(view.getTop());
        serializableView.setLeft(view.getLeft());
        serializableView.setRight(view.getRight());
        serializableView.setHeight(view.getHeight());
        serializableView.setWidth(view.getWidth());
        serializableView.setId(view.getId());
        return serializableView;
    }
}
