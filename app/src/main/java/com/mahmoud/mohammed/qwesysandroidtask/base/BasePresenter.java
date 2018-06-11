package com.mahmoud.mohammed.qwesysandroidtask.base;

public interface BasePresenter<V extends BaseView> {
    void setView(V view);
}
