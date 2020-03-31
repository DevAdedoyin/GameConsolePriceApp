package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hiText)
    TextView hiText;
    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewCustomAdapter recyclerViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustomAdapter = new RecyclerViewCustomAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewCustomAdapter);

        Observable.just("Hey what's up.").subscribe(s -> hiText.setText(s));

        Entry entry1 = new Entry("PS4", BigDecimal.valueOf(1500), new Date());
        Entry entry2 = new Entry("Xbox One", BigDecimal.valueOf(2000), new Date());
        Entry entry3 = new Entry("Xbox One s", BigDecimal.valueOf(2500), new Date());
        Entry entry4 = new Entry("Xbox One X", BigDecimal.valueOf(3000), new Date());

        Observable.just(entry1, entry2, entry3, entry4).subscribe(recyclerViewCustomAdapter::addEntry);

    }
}