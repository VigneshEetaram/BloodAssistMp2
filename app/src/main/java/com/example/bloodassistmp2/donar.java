package com.example.bloodassistmp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class donar extends AppCompatActivity {
    public static final String TAG = "TAG";
    TextView DfullName, Ddob, Dbg, Dph, Demail, Daddress;
Button Dsave;
FirebaseFirestore fStore;
String userID;
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
        Dsave = findViewById(R.id.donarSaveBtn);
        fStore = FirebaseFirestore.getInstance();

        Dsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Dfn = DfullName.getText().toString();
                String Dbirth = Ddob.getText().toString();
                String Dgroup = Dbg.getText().toString();
                String Dphone = Dph.getText().toString();
                String Dmail = Demail.getText().toString();
                String Dfaddress = Daddress.getText().toString();


            }

        });
        DocumentReference documentReference = fStore.collection("donors").document(userID);
        Map<String, Object> donarDetails = new HashMap<>();
        donarDetails.put("fName", DfullName);
        donarDetails.put("birth", Ddob);
        documentReference.set(donarDetails).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "onSuccess: Donar Details Added ");
            }
        });




    }
}