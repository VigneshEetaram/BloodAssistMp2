package com.example.bloodassistmp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bloodassistmp2.models.donar_model;
import com.example.bloodassistmp2.models.receiver_model;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Receiver extends AppCompatActivity {
    EditText DfullName, Ddob, Dbg, Dph, Demail, Daddress;
    Button DsaveBtn;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        DfullName = findViewById(R.id.rFullName);
        Ddob = findViewById(R.id.rdob);
        Dbg = findViewById(R.id.rbG);
        Dph = findViewById(R.id.rPh);
        Demail = findViewById(R.id.rEmail);
        Daddress = findViewById(R.id.rAddress);
        DsaveBtn = findViewById(R.id.placeRequestBtn);
        db = FirebaseFirestore.getInstance();
        DsaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = DfullName.getText().toString();
                String blodgroup = Dbg.getText().toString();
                addData(name, blodgroup);
            }
        });
    }
        public void addData(String fullName,String bloodGroup){
            receiver_model receivers = new receiver_model(fullName,bloodGroup);
            db.collection("receiver")
                    .add(receivers)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(),"Request Recorded !!",Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"not recorded!!",Toast.LENGTH_LONG).show();
                        }
                    });
    }
}