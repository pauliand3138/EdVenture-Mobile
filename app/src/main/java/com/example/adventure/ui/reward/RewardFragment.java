package com.example.adventure.ui.reward;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adventure.Cart;
import com.example.adventure.Home;
import com.example.adventure.Login;
import com.example.adventure.Model.CartItem;
import com.example.adventure.Model.User;
import com.example.adventure.R;
import com.example.adventure.Register;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RewardFragment extends Fragment {
    ImageView grab, foodpanda, tshirt, handbag, textbook, tealive, cart;
    TextView cartItemQty;
    FirebaseDatabase database;
    DatabaseReference cartTable;
    private RewardViewModel mViewModel;

    public static RewardFragment newInstance() {
        return new RewardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reward, container, false);

        database = FirebaseDatabase.getInstance("https://edventure-628aa-default-rtdb.asia-southeast1.firebasedatabase.app/");
        cartTable = database.getReference("Cart");

        grab = v.findViewById(R.id.grab);
        foodpanda = v.findViewById(R.id.foodpanda);
        tshirt = v.findViewById(R.id.tshirt);
        handbag = v.findViewById(R.id.handbag);
        textbook = v.findViewById(R.id.textbook);
        tealive = v.findViewById(R.id.tealive);
        cart = v.findViewById(R.id.cart);
        cartItemQty = v.findViewById(R.id.cartItemQty);

        grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View grabDialog = inflater.inflate(R.layout.grab_alertdialog,null);

                ImageView itemImage = grabDialog.findViewById(R.id.itemImage);
                TextView itemName = grabDialog.findViewById(R.id.itemName);
                ImageView addButton = grabDialog.findViewById(R.id.addButton);
                ImageView minusButton = grabDialog.findViewById(R.id.minusButton);
                MaterialButton addtoCartButton = grabDialog.findViewById(R.id.addtoCartButton);
                MaterialButton closeButton = grabDialog.findViewById(R.id.closeButton);
                TextView itemQty = grabDialog.findViewById(R.id.qtyText);

                builder.setView(grabDialog);

                final AlertDialog dialog = builder.create();

                addtoCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                CartItem cartItem = new CartItem(itemName.getText().toString(), "500 Points", itemQty.getText().toString());
                                cartTable.child(itemName.getText().toString()).setValue(cartItem);
                                dialog.dismiss();
                                Toast.makeText(getActivity(), "Added to Cart! ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        addToCartQty++;
                        itemQty.setText(String.valueOf(addToCartQty));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        if(addToCartQty > 1) {
                            addToCartQty--;
                            itemQty.setText(String.valueOf(addToCartQty));
                        }
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        foodpanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View foodpandaDialog = inflater.inflate(R.layout.foodpanda_alertdialog,null);

                ImageView itemImage = foodpandaDialog.findViewById(R.id.itemImage);
                TextView itemName = foodpandaDialog.findViewById(R.id.itemName);
                ImageView addButton = foodpandaDialog.findViewById(R.id.addButton);
                ImageView minusButton = foodpandaDialog.findViewById(R.id.minusButton);
                MaterialButton addtoCartButton = foodpandaDialog.findViewById(R.id.addtoCartButton);
                MaterialButton closeButton = foodpandaDialog.findViewById(R.id.closeButton);
                TextView itemQty = foodpandaDialog.findViewById(R.id.qtyText);

                builder.setView(foodpandaDialog);

                final AlertDialog dialog = builder.create();

                addtoCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                CartItem cartItem = new CartItem(itemName.getText().toString(), "500 Points", itemQty.getText().toString());
                                cartTable.child(itemName.getText().toString()).setValue(cartItem);
                                dialog.dismiss();
                                Toast.makeText(getActivity(), "Added to Cart! ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        addToCartQty++;
                        itemQty.setText(String.valueOf(addToCartQty));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        if(addToCartQty > 1) {
                            addToCartQty--;
                            itemQty.setText(String.valueOf(addToCartQty));
                        }
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View tshirtDialog = inflater.inflate(R.layout.tshirt_alertdialog,null);

                ImageView itemImage = tshirtDialog.findViewById(R.id.itemImage);
                TextView itemName = tshirtDialog.findViewById(R.id.itemName);
                ImageView addButton = tshirtDialog.findViewById(R.id.addButton);
                ImageView minusButton = tshirtDialog.findViewById(R.id.minusButton);
                MaterialButton addtoCartButton = tshirtDialog.findViewById(R.id.addtoCartButton);
                MaterialButton closeButton = tshirtDialog.findViewById(R.id.closeButton);
                TextView itemQty = tshirtDialog.findViewById(R.id.qtyText);

                builder.setView(tshirtDialog);

                final AlertDialog dialog = builder.create();

                addtoCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                CartItem cartItem = new CartItem(itemName.getText().toString(), "500 Points", itemQty.getText().toString());
                                cartTable.child(itemName.getText().toString()).setValue(cartItem);
                                dialog.dismiss();
                                Toast.makeText(getActivity(), "Added to Cart! ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        addToCartQty++;
                        itemQty.setText(String.valueOf(addToCartQty));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        if(addToCartQty > 1) {
                            addToCartQty--;
                            itemQty.setText(String.valueOf(addToCartQty));
                        }
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        handbag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View handbagDialog = inflater.inflate(R.layout.handbag_alertdialog,null);

                ImageView itemImage = handbagDialog.findViewById(R.id.itemImage);
                TextView itemName = handbagDialog.findViewById(R.id.itemName);
                ImageView addButton = handbagDialog.findViewById(R.id.addButton);
                ImageView minusButton = handbagDialog.findViewById(R.id.minusButton);
                MaterialButton addtoCartButton = handbagDialog.findViewById(R.id.addtoCartButton);
                MaterialButton closeButton = handbagDialog.findViewById(R.id.closeButton);
                TextView itemQty = handbagDialog.findViewById(R.id.qtyText);

                builder.setView(handbagDialog);

                final AlertDialog dialog = builder.create();

                addtoCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                CartItem cartItem = new CartItem(itemName.getText().toString(), "500 Points", itemQty.getText().toString());
                                cartTable.child(itemName.getText().toString()).setValue(cartItem);
                                dialog.dismiss();
                                Toast.makeText(getActivity(), "Added to Cart! ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        addToCartQty++;
                        itemQty.setText(String.valueOf(addToCartQty));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        if(addToCartQty > 1) {
                            addToCartQty--;
                            itemQty.setText(String.valueOf(addToCartQty));
                        }
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        textbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View textbookDialog = inflater.inflate(R.layout.textbook_alertdialog,null);

                ImageView itemImage = textbookDialog.findViewById(R.id.itemImage);
                TextView itemName = textbookDialog.findViewById(R.id.itemName);
                ImageView addButton = textbookDialog.findViewById(R.id.addButton);
                ImageView minusButton = textbookDialog.findViewById(R.id.minusButton);
                MaterialButton addtoCartButton = textbookDialog.findViewById(R.id.addtoCartButton);
                MaterialButton closeButton = textbookDialog.findViewById(R.id.closeButton);
                TextView itemQty = textbookDialog.findViewById(R.id.qtyText);

                builder.setView(textbookDialog);

                final AlertDialog dialog = builder.create();

                addtoCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                CartItem cartItem = new CartItem(itemName.getText().toString(), "500 Points", itemQty.getText().toString());
                                cartTable.child(itemName.getText().toString()).setValue(cartItem);
                                dialog.dismiss();
                                Toast.makeText(getActivity(), "Added to Cart! ", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        addToCartQty++;
                        itemQty.setText(String.valueOf(addToCartQty));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        if(addToCartQty > 1) {
                            addToCartQty--;
                            itemQty.setText(String.valueOf(addToCartQty));
                        }
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        tealive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View tealiveDialog = inflater.inflate(R.layout.tealive_alertdialog,null);

                ImageView itemImage = tealiveDialog.findViewById(R.id.itemImage);
                TextView itemName = tealiveDialog.findViewById(R.id.itemName);
                ImageView addButton = tealiveDialog.findViewById(R.id.addButton);
                ImageView minusButton = tealiveDialog.findViewById(R.id.minusButton);
                MaterialButton addtoCartButton = tealiveDialog.findViewById(R.id.addtoCartButton);
                MaterialButton closeButton = tealiveDialog.findViewById(R.id.closeButton);
                TextView itemQty = tealiveDialog.findViewById(R.id.qtyText);

                builder.setView(tealiveDialog);

                final AlertDialog dialog = builder.create();

                addtoCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cartTable.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                CartItem cartItem = new CartItem(itemName.getText().toString(), "500 Points", itemQty.getText().toString());
                                cartTable.child(itemName.getText().toString()).setValue(cartItem);
                                dialog.dismiss();
                                Toast.makeText(getActivity(), "Added to Cart! ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        addToCartQty++;
                        itemQty.setText(String.valueOf(addToCartQty));
                    }
                });

                minusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int addToCartQty = Integer.parseInt(itemQty.getText().toString());
                        if(addToCartQty > 1) {
                            addToCartQty--;
                            itemQty.setText(String.valueOf(addToCartQty));
                        }
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Cart.class);
                startActivity(intent);
            }
        });

        cartTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    int itemQty = 0;
                    for (DataSnapshot d : snapshot.getChildren()) {
                        itemQty++;
                    }
                    cartItemQty.setText(String.valueOf(itemQty));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RewardViewModel.class);
        // TODO: Use the ViewModel
    }

}