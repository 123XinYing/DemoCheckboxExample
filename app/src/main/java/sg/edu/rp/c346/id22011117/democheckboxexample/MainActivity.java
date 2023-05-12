package sg.edu.rp.c346.id22011117.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private double calcPay(double price, double discount) {
        double pay = price * (1 - discount/100);
        return pay;
}

    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnabled = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String said = "";
                if (cbEnabled.isChecked()) {
                    btnCheck.setEnabled(true);
                    tvShow.setText("The discount is given");
                } else {
                    btnCheck.setEnabled(false);
                    tvShow.setText("The discount is not given");
                }
                Toast.makeText(MainActivity.this, "Click Button", Toast.LENGTH_LONG).show();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                Toast.makeText(MainActivity.this, "Click Button", Toast.LENGTH_LONG).show();
                if (cbEnabled.isChecked()) {
                    double pay = calcPay(100, 20);
                    tvShow.setText("The discount is given. You need to pay " + pay);
                } else {
                    double pay = calcPay(100, 0);
                    tvShow.setText("The discount is not given. You need to pay " + pay);
                }
            }
        });