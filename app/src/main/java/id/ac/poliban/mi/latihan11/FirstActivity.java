package id.ac.poliban.mi.latihan11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    check EditText apakah kosong atau tidak, jika kosong tampilkan pesan
    buat Intent
    konversi nilai etFirstNo ke integer dan sertakan dalam intent
    konversi nilai etSecondNo ke integer dan sertakan dalam intent
*/

public class FirstActivity extends AppCompatActivity {
    private EditText etFirstNo;
    private EditText etSecondNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etFirstNo = findViewById(R.id.etFirstNo);
        etSecondNo = findViewById(R.id.etSecondNo);
        Button btCalculate = findViewById(R.id.btCalculate);
        btCalculate.setOnClickListener(view -> {
            if (etFirstNo.getText().toString().isEmpty() || etSecondNo.getText().toString().isEmpty()) {
                Toast.makeText(this, "fill all the fields pls...", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("fNo", Integer.parseInt(etFirstNo.getText().toString()));
            intent.putExtra("sNo", Integer.parseInt(etSecondNo.getText().toString()));
            startActivity(intent);
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        etFirstNo.setText("");
        etSecondNo.setText("");
        etFirstNo.requestFocus();
    }
}
