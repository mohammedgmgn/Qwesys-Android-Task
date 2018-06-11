package com.mahmoud.mohammed.qwesysandroidtask.base;

public interface BaseView {
    void showMessage(String message);
    void showLoadingDialog(String message);
    void dismissLoadingDialog();
    void showErrMsg(String msg);
    void showNoInternetMsg();

}
