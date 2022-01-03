package com.example.loginfirebase;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class Purchase extends Fragment {

    public static ArrayList<Object> itemTitle = new ArrayList<Object>();

    public static int grandTotal = 0;



    public ArrayList<Object> Purchase(){
        return itemTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =
                inflater.inflate(R.layout.fragment_purchase, container, false);

        //bind edittext
        EditText ed1 = (EditText) view.findViewById(R.id.ed1);
        EditText ed2 = (EditText) view.findViewById(R.id.ed2);
        EditText ed3 = (EditText) view.findViewById(R.id.ed3);
        EditText ed4 = (EditText) view.findViewById(R.id.ed4);
        EditText ed5 = (EditText) view.findViewById(R.id.ed5);
        EditText ed6 = (EditText) view.findViewById(R.id.ed6);


        //BIND BUTTONS

        Button cart1 = (Button) view.findViewById(R.id.cart1);
        Button cart2 = (Button) view.findViewById(R.id.cart2);
        Button cart3 = (Button) view.findViewById(R.id.cart3);
        Button cart4 = (Button) view.findViewById(R.id.cart4);
        Button cart5 = (Button) view.findViewById(R.id.cart5);
        Button cart6 = (Button) view.findViewById(R.id.cart6);



        //onclick listener
        itemTitle.add(grandTotal);
        if(itemTitle.size() <= 9){
            cart1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int countClicks = 0;

                    countClicks ++;
                    if(ed1.getText().toString().trim().length() > 0){
                        String temp = ed1.getText().toString();
                        int count =Integer.parseInt(temp);
                        int price = 50;
                        if(countClicks == 1){
                            price = price * count;
                            grandTotal = grandTotal + price;
                            itemTitle.set(0,grandTotal);
                            itemTitle.add("Shoe");
                            itemTitle.add(count);
                            itemTitle.add(price);
                        }
                    }
                }
            });

            cart2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int countClicks = 0;

                    countClicks ++;
                    if(ed2.getText().toString().trim().length() > 0){
                        String temp = ed2.getText().toString();
                        int count =Integer.parseInt(temp);
                        int price = 45;
                        if(countClicks == 1){
                            price = price * count;
                            grandTotal = grandTotal + price;
                            itemTitle.set(0,grandTotal);
                            itemTitle.add("Shirts");
                            itemTitle.add(count);
                            itemTitle.add(price);
                        }
                    }
                }
            });
            cart3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int countClicks = 0;

                    countClicks ++;
                    if(ed3.getText().toString().trim().length() > 0){
                        String temp = ed3.getText().toString();
                        int count =Integer.parseInt(temp);
                        int price = 60;
                        if(countClicks == 1){
                            price = price * count;
                            grandTotal = grandTotal + price;
                            itemTitle.set(0,grandTotal);
                            itemTitle.add("Pants");
                            itemTitle.add(count);
                            itemTitle.add(price);
                        }
                    }
                }
            });
            cart4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int countClicks = 0;

                    countClicks ++;
                    if(ed4.getText().toString().trim().length() > 0){
                        String temp = ed4.getText().toString();
                        int count =Integer.parseInt(temp);
                        int price = 150;
                        if(countClicks == 1){
                            price = price * count;
                            grandTotal = grandTotal + price;
                            itemTitle.set(0,grandTotal);
                            itemTitle.add("Laptop");
                            itemTitle.add(count);
                            itemTitle.add(price);
                        }
                    }
                }
            });
            cart5.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int countClicks = 0;

                    countClicks ++;
                    if(ed5.getText().toString().trim().length() > 0){
                        String temp = ed5.getText().toString();
                        int count =Integer.parseInt(temp);
                        int price = 50;
                        if(countClicks == 1){
                            price = price * count;
                            grandTotal = grandTotal + price;
                            itemTitle.set(0,grandTotal);
                            itemTitle.add("SmartPhone");
                            itemTitle.add(count);
                            itemTitle.add(price);
                        }
                    }
                }
            });
            cart6.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int countClicks = 0;

                    countClicks ++;
                    if(ed6.getText().toString().trim().length() > 0){
                        String temp = ed6.getText().toString();
                        int count =Integer.parseInt(temp);
                        int price = 130;
                        if(countClicks == 1){
                            price = price * count;
                            grandTotal = grandTotal + price;
                            itemTitle.set(0,grandTotal);
                            itemTitle.add("Smart Tv");
                            itemTitle.add(count);
                            itemTitle.add(price);
                        }
                    }
                }
            });
        }else{
            Toast.makeText(getActivity(),  "MAXIMUM ITEMS ADDED TO CART", Toast.LENGTH_SHORT).show();
        }





        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        itemTitle.clear();
    }
}