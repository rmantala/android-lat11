package id.ac.poliban.mi.latihan11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvResult = findViewById(R.id.tvResult);

        if(getIntent().getExtras()==null) {
            tvResult.setText("Sorry there's no bundle in intent");
            return;
        }

        int fNo = getIntent().getIntExtra("fNo", 1);
        int sNo = getIntent().getIntExtra("sNo", 1);

        int bigNo, smallNo;
        int result;

        if(fNo>sNo){
            bigNo = fNo;
            smallNo = sNo;
        }
        else{
            bigNo=sNo;
            smallNo = fNo;
        }

        while((result= bigNo % smallNo)!=0){
            bigNo = smallNo;
            smallNo = result;
        }

        tvResult.setText(String.format("GCF = %3d", smallNo));

    }
}
