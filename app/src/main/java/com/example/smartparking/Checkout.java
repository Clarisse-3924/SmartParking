package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        CardForm cardForm=findViewById(R.id.cardform);
        TextView txv= findViewById(R.id.payment_amount);
        Button btnPay=findViewById(R.id.btn_pay);

        txv.setText("500RWF");
        btnPay.setText(String.format("Payer is", txv.getText()));

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                //Toast.makeText(Checkout.this, "Name:"+ card.getName()+" |Last 4 Digits:"+ card.getLast4(), Toast.LENGTH_SHORT).show();
                Toast.makeText(Checkout.this, "Number:"+card.getNumber()+"|CVC:"+ card.getCVC(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}