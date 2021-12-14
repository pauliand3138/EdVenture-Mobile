package com.example.adventure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.adventure.Model.CartItem;
import com.example.adventure.ViewHolder.CartViewHolder;
import com.example.adventure.ui.reward.RewardFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Cart extends AppCompatActivity {
    ImageView backButton;

    RecyclerView recyclerView;

    FirebaseDatabase database;
    DatabaseReference cartTable;

    FirebaseRecyclerAdapter<CartItem, CartViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });

        database = FirebaseDatabase.getInstance("https://edventure-628aa-default-rtdb.asia-southeast1.firebasedatabase.app/");
        cartTable = database.getReference("Cart");



        recyclerView = findViewById(R.id.itemList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadItems();

    }

    private void loadItems() {
        adapter = new FirebaseRecyclerAdapter<CartItem, CartViewHolder>(CartItem.class, R.layout.cart_item_layout, CartViewHolder.class, cartTable) {
            @Override
            protected void populateViewHolder(CartViewHolder cartViewHolder, CartItem cartItem, int i) {
                cartViewHolder.itemName.setText(cartItem.getItemName());
                cartViewHolder.itemPoints.setText(cartItem.getItemPoints());
                cartViewHolder.itemQty.setText(cartItem.getItemQty());

                if(cartItem.getItemName().equals("RM 20 FOODPANDA VOUCHER")) {
                    cartViewHolder.itemImage.setImageResource(R.drawable.foodpandaphoto);
                } else if (cartItem.getItemName().equals("RM 10 GRAB GIFT CARD")) {
                    cartViewHolder.itemImage.setImageResource(R.drawable.grabphoto);
                } else if (cartItem.getItemName().equals("EdVenture HandBag")) {
                    cartViewHolder.itemImage.setImageResource(R.drawable.handbagphoto);
                } else if (cartItem.getItemName().equals("Tealive Drink")) {
                    cartViewHolder.itemImage.setImageResource(R.drawable.tealivephoto);
                } else if (cartItem.getItemName().equals("TextBook")) {
                    cartViewHolder.itemImage.setImageResource(R.drawable.textbookphoto);
                } else {
                    cartViewHolder.itemImage.setImageResource(R.drawable.tshirtphoto);
                }

            }
        };
        recyclerView.setAdapter(adapter);
    }
}