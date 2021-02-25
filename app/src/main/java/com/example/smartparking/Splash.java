package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;

public class Splash extends AppCompatActivity {

    Button btnpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnpay=findViewById(R.id.paybtn);
        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RaveUiManager(Splash.this).setAmount(10)
                        .setCurrency("RWF")
                        .setEmail("ubelyse1@gmail.com")
                        .setfName("Belyse")
                        .setlName("Uwambayinema")
                        .setNarration("narration")
                        .setPublicKey("FLWPUBK-153c54964b77d3382386e19706048494-X")
                        .setEncryptionKey("1a59522dfb665a5bd9e0c0e2")
                        .setTxRef("txRef")
                        .setPhoneNumber("+250787905576", true)
                    .acceptAccountPayments(false)
                    .acceptCardPayments(true)
                    .acceptMpesaPayments(false)
                    .acceptAchPayments(false)
                    .acceptGHMobileMoneyPayments(false)
                    .acceptUgMobileMoneyPayments(false)
                    .acceptZmMobileMoneyPayments(false)
                    .acceptRwfMobileMoneyPayments(true)
                    .acceptSaBankPayments(false)
                    .acceptUkPayments(false)
                    .acceptBankTransferPayments(false)
                    .acceptUssdPayments(false)
                    .acceptBarterPayments(false)
                    .acceptFrancMobileMoneyPayments(false)
                    .allowSaveCardFeature(false)
                    .onStagingEnv(false)
                        .withTheme(R.style.MyCustomTheme)
                    .initialize();
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*
         *  We advise you to do a further verification of transaction's details on your server to be
         *  sure everything checks out before providing service or goods.
         */
        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            String message = data.getStringExtra("response");
            if (resultCode == RavePayActivity.RESULT_SUCCESS) {
                Toast.makeText(this, "SUCCESS " + message, Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RavePayActivity.RESULT_ERROR) {
                Toast.makeText(this, "ERROR " + message, Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
                Toast.makeText(this, "CANCELLED " + message, Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}