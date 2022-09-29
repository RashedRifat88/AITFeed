package com.egsystembd.aitfeed.ui.payment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.egsystembd.aitfeed.R;

public class PaymentActivity extends AppCompatActivity {

    CardView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
//        ActionBar ab = ((AppCompatActivity) this).getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
//        ab.setTitle("পেমেন্ট");

        initView();
    }

    private void initView() {
        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);

//        cardView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                addOrder();
//                Intent i = new Intent(PaymentActivity.this, PaymentWithCashActivity.class);
//                i.putExtra("PAYMENT_OPTION", "1");
//                startActivity(i);
////                finish();
//            }
//        });
//
//        cardView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(PaymentActivity.this, PaymentWithBank1stStepActivity.class);
//                i.putExtra("PAYMENT_OPTION", "2");
//                i.putExtra("PAYMENT_TYPE", "Bank and Cash");
//                startActivity(i);
////                finish();
//            }
//        });
//
//        cardView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(PaymentActivity.this, PaymentWithBank1stStepActivity.class);
//                i.putExtra("PAYMENT_OPTION", "2");
//                i.putExtra("PAYMENT_TYPE", "Pay Order");
//                startActivity(i);
////                finish();
//            }
//        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    onBackPressed();
                }
//                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}