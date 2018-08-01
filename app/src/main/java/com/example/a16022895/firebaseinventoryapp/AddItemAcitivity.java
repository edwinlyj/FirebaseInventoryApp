package com.example.a16022895.firebaseinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemAcitivity extends AppCompatActivity {
        private static final String TAG = "AddItemAcitivity";

        private EditText etName, etAge;
        private Button btnAdd;
        private FirebaseDatabase firebaseDatabase;
        private DatabaseReference studentListRef;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_item_acitivity);
            etName = (EditText)findViewById(R.id.editTextName);
            etAge = (EditText)findViewById(R.id.editTextUCost);
            btnAdd = (Button)findViewById(R.id.buttonAdd);

            firebaseDatabase = FirebaseDatabase.getInstance();
            studentListRef = firebaseDatabase.getReference("/itemList");


            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = etName.getText().toString();
                    Double Ucost = Double.parseDouble(etAge.getText().toString());
                    Item item = new Item(name, Ucost);

                    studentListRef.push().setValue(item);

                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

        }
}
