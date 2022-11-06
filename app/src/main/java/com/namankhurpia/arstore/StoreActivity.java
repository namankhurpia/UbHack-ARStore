package com.namankhurpia.arstore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    ArrayList<Store> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://vrstore-ubhack-default-rtdb.firebaseio.com/");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()) {

                    Log.d("Count " ,""+snapshot.getChildrenCount());

                    Store appobj = ds.getValue(Store.class);

                    String appname  = appobj.getAppname();
                    String appurl = appobj.getAppurl();
                    String appiconurl = appobj.getAppiconpath();
                    String ownername = appobj.getOwnername();
                    String stars = appobj.getStars();

                    list.add(appobj);
                    System.out.println(appobj.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        System.out.println(list);


    }

}