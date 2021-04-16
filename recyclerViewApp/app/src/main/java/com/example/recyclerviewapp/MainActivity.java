package com.example.recyclerviewapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<ModelClass>list;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initRecyclerView();
    }

    private void initData() {
        list=new ArrayList<>();
        list.add(new ModelClass(R.drawable.sixth,"Tasmia Shafi","10:45 AM","How are you??","___________________________________"));
        list.add(new ModelClass(R.drawable.first,"Fatima Tahir","1:32 PM","Hii!! Whatsup??","___________________________________"));
        list.add(new ModelClass(R.drawable.third,"Haleema Mustafa","00:45 AM","Assalam-o-Alaikum!!","___________________________________"));
        list.add(new ModelClass(R.drawable.first,"Simra Malik","09:45 PM","How are you??","___________________________________"));
        list.add(new ModelClass(R.drawable.fourth,"Momina Rasheed","07:45 AM","How are you??","___________________________________"));
        list.add(new ModelClass(R.drawable.second,"Aqsa Ijaz","08:50 PM","How are you??","___________________________________"));
        list.add(new ModelClass(R.drawable.third,"Maham Fareed","09:00 AM","How are you??","___________________________________"));
        list.add(new ModelClass(R.drawable.fifth,"Apii","09:00 AM","Yr bat suno!!","___________________________________"));
        list.add(new ModelClass(R.drawable.seven,"Hifza Awais","09:00 AM","AOA ka homework kr lea?","___________________________________"));
        list.add(new ModelClass(R.drawable.second,"Ayesha Sheikh","09:00 AM","Yara bat suno meri.","___________________________________"));
        
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new Adapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}