package com.example.a14_recyclerview_drag_and_swipe_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a14_recyclerview_drag_and_swipe_java.R;
import com.example.a14_recyclerview_drag_and_swipe_java.helper.ItemTouchHelperAdapter;
import com.example.a14_recyclerview_drag_and_swipe_java.model.Member;

import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {
    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
    if(holder instanceof CustomViewHolder) {
        TextView first_name = ((CustomViewHolder) holder).first_name;
        TextView last_name = ((CustomViewHolder) holder).last_name;

        first_name.setText(member.getFirstName());
        last_name.setText(member.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if(fromPosition<toPosition){
            for(int i = fromPosition; i< toPosition;i++){
                Collections.swap(members,i,i+1);
            }
        }else{
            for(int i = fromPosition; i >toPosition;i--){
                Collections.swap(members,i,i-1);
            }
        }
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
            members.remove(position);
            notifyItemRemoved(position);
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView first_name, last_name;
        public CustomViewHolder(View v) {
            super(v);
            view = v;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }


}
