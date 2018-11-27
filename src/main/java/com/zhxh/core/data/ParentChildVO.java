package com.zhxh.core.data;

public interface ParentChildVO<T> {
    default boolean isLeaf() {
        return this.getChildren() == null || this.getChildren().length == 0;
    }
    default boolean isExpanded(){
        return !this.isLeaf();
    }

    T[] getChildren();
    void setChildren(T[] children);

}
