package com.example.a14_recyclerview_drag_and_swipe_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaMetadata;
import android.os.Bundle;

import com.example.a14_recyclerview_drag_and_swipe_java.adapter.CustomAdapter;
import com.example.a14_recyclerview_drag_and_swipe_java.helper.SimpleItemTouchHelperCallBack;
import com.example.a14_recyclerview_drag_and_swipe_java.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for(int i = 1; i<20; i++){
            members.add(new Member("Sarvar"+i,"Khalmatov"+i));
        }
        return members;
    }
}