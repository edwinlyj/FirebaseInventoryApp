package com.example.a16022895.firebaseinventoryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemDetailsActivity extends AppCompatActivity {

    private static final String TAG = "StudentDetailsActivity";

    private EditText etName, etAge;
    private Button btnUpdate, btnDelete;

    private Item item;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference ItemListRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        etName = (EditText)findViewById(R.id.editTextName);
        etAge = (EditText)findViewById(R.id.editTextUCost);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);
        btnDelete = (Button)findViewById(R.id.buttonDelete);

        firebaseDatabase = FirebaseDatabase.getInstance();
        ItemListRef = firebaseDatabase.getReference("/itemList");

        Intent intent = getIntent();
        item = (Item) intent.getSerializableExtra("Item");

        //Display Student details as retrieved from the intent
        etName.setText(item.getName());
        etAge.setText(String.valueOf(item.getUnitCost()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                double ucost = Double.parseDouble(etAge.getText().toString());
                Item studentn = new Item(name, ucost);
                ItemListRef.child(item.getId()).setValue(studentn);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Item record updated successfully", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ItemListRef.child(item.getId()).removeValue();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Item record deleted successfully", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });

    }

}