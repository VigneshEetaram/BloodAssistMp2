package com.example.bloodassistmp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloodassistmp2.models.donar_model;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class donar extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText DfullName, Ddob, Dbg, Dph, Demail, Daddress;
    Button DsaveBtn;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar);

        DfullName = findViewById(R.id.dFullName);
        Ddob = findViewById(R.id.Ddob);
        Dbg = findViewById(R.id.DbG);
        Dph = findViewById(R.id.dPh);
        Demail = findViewById(R.id.dEmail);
        Daddress = findViewById(R.id.dAddress);
        DsaveBtn = findViewById(R.id.donarSaveBtn);
        db = FirebaseFirestore.getInstance();

        DsaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=DfullName.getText().toString();
                String blodgroup=Dbg.getText().toString();
                addData(name,blodgroup);
            }
        });

    }
    public void addData(String fullName,String bloodGroup){
        donar_model donars = new donar_model(fullName,bloodGroup);
        db.collection("donars")
                .add(donars)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Donar Recorded !!",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"nor recorded!!",Toast.LENGTH_LONG).show();
                    }
                });
    }
}