package info.fahri.aplikasicurhat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailCurhatActivity extends AppCompatActivity {

    TextView txtDetailNama, txtDetailKonten;

    Curhat curhat;
    FirebaseFirestore firedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_curhar);
        txtDetailKonten = findViewById(R.id.txtDetailKonten);
        txtDetailNama = findViewById(R.id.txtNamaDetail);

        Intent it = getIntent();
        curhat = (Curhat) it.getSerializableExtra("current_curhat");
        txtDetailNama.setText(curhat.email);
        txtDetailKonten.setText(curhat.konten);

        firedb = FirebaseFirestore.getInstance();
    }

    public void close(View v){
        finish();
    }

    public void deleteCurhat(View v){g
        firedb.collection("curhat").document(curhat.uid)
                        .delete().addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("error_delete", e.getMessage());
                    }
                });
        finish();
    }
}
