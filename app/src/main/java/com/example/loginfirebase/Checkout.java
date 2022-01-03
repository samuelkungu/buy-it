package com.example.loginfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Checkout extends Fragment {
    TextView tv1a, tv1b, tv1c, tv2a, tv2b, tv2c, tv3a, tv3b, tv3c,tvgrandTotal;
    Button payment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =
                inflater.inflate(R.layout.fragment_checkout, container, false);
        tv1a = (TextView) view.findViewById(R.id.checkout1a);
        tv1b = (TextView) view.findViewById(R.id.checkout1b);
        tv1c = (TextView) view.findViewById(R.id.checkout1c);
        tv2a = (TextView) view.findViewById(R.id.checkout2a);
        tv2b = (TextView) view.findViewById(R.id.checkout2b);
        tv2c = (TextView) view.findViewById(R.id.checkout2c);
        tv3a = (TextView) view.findViewById(R.id.checkout3a);
        tv3b = (TextView) view.findViewById(R.id.checkout3b);
        tv3c = (TextView) view.findViewById(R.id.checkout3c);
        tvgrandTotal = (TextView) view.findViewById(R.id.grandTotal);

        payment = (Button) view.findViewById(R.id.payment);






        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Purchase title = new Purchase();
        if (title.itemTitle != null) {


            int size = title.itemTitle.size();
            if (size == 4) {

                tv1a.setText(String.valueOf(Purchase.itemTitle.get(1)));
                tv1b.setText(String.valueOf(Purchase.itemTitle.get(2)));
                tv1c.setText(String.valueOf(Purchase.itemTitle.get(3)));
                tvgrandTotal.setText(String.valueOf(Purchase.itemTitle.get(0)));

            } else if (size == 7) {
                tv1a.setText(String.valueOf(Purchase.itemTitle.get(1)));
                tv1b.setText(String.valueOf(Purchase.itemTitle.get(2)));
                tv1c.setText(String.valueOf(Purchase.itemTitle.get(3)));
                tv2a.setText(String.valueOf(Purchase.itemTitle.get(4)));
                tv2b.setText(String.valueOf(Purchase.itemTitle.get(5)));
                tv2c.setText(String.valueOf(Purchase.itemTitle.get(6)));
                tvgrandTotal.setText(String.valueOf(Purchase.itemTitle.get(0)));
            } else if (size == 10) {
                tv1a.setText(String.valueOf(Purchase.itemTitle.get(1)));
                tv1b.setText(String.valueOf(Purchase.itemTitle.get(2)));
                tv1c.setText(String.valueOf(Purchase.itemTitle.get(3)));
                tv2a.setText(String.valueOf(Purchase.itemTitle.get(4)));
                tv2b.setText(String.valueOf(Purchase.itemTitle.get(5)));
                tv2c.setText(String.valueOf(Purchase.itemTitle.get(6)));
                tv3a.setText(String.valueOf(Purchase.itemTitle.get(7)));
                tv3b.setText(String.valueOf(Purchase.itemTitle.get(8)));
                tv3c.setText(String.valueOf(Purchase.itemTitle.get(9)));
                tvgrandTotal.setText(String.valueOf(Purchase.itemTitle.get(0)));
            }
//            else{
//                Toast.makeText(getActivity(),  "CHECKOUT", Toast.LENGTH_SHORT).show();
//            }

        }
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Payment Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}