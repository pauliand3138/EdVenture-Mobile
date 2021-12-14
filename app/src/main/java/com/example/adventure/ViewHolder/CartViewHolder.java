package com.example.adventure.ViewHolder;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adventure.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CartViewHolder extends RecyclerView.ViewHolder {
    public CheckBox checkBox;
    public ImageView itemImage, addButton, minusButton, trashButton;
    public TextView itemName, itemPoints, itemQty;

    FirebaseDatabase database;
    DatabaseReference cartTable;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.checkbox);
        itemImage = itemView.findViewById(R.id.itemPhoto);
        addButton = itemView.findViewById(R.id.addButton);
        minusButton = itemView.findViewById(R.id.minusButton);
        itemName = itemView.findViewById(R.id.itemName);
        itemPoints = itemView.findViewById(R.id.itemPoints);
        itemQty = itemView.findViewById(R.id.qtyText);
        trashButton = itemView.findViewById(R.id.trashButton);

        database = FirebaseDatabase.getInstance("https://edventure-628aa-default-rtdb.asia-southeast1.firebasedatabase.app/");
        cartTable = database.getReference("Cart");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                addToCartQty++;
                itemQty.setText(String.valueOf(addToCartQty));
                cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        cartTable.child(itemName.getText().toString()).child("itemQty").setValue(itemQty.getText().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                if(addToCartQty > 1) {
                    addToCartQty--;
                    itemQty.setText(String.valueOf(addToCartQty));
                    cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            cartTable.child(itemName.getText().toString()).child("itemQty").setValue(itemQty.getText().toString());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        trashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(itemView.getContext());
                alertDialog.setTitle("Delete Confirmation!");
                alertDialog.setMessage("Are you sure to remove the item from cart?");

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cartTable.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                cartTable.child(itemName.getText().toString()).removeValue();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }
}
