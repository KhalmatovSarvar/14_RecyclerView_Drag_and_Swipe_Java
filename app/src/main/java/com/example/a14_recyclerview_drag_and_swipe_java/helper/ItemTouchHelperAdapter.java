package com.example.a14_recyclerview_drag_and_swipe_java.helper;

public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition,int toPosition);
    void onItemDismiss(int position);
}
