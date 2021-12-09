package com.example.adventure.ui.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.adventure.R;
import com.example.adventure.databinding.FragmentCoursesBinding;
import com.google.android.material.button.MaterialButton;

public class CoursesFragment extends Fragment {
    ImageView algorithm, dataStructure;
    private CoursesViewModel coursesViewModel;
    private FragmentCoursesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        coursesViewModel =
                new ViewModelProvider(this).get(CoursesViewModel.class);

        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        algorithm = root.findViewById(R.id.algorithm);
        dataStructure = root.findViewById(R.id.dataStructure);

        dataStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View courseAlertDialog = inflater.inflate(R.layout.course_alertdialog,null);

                MaterialButton enrollButton = courseAlertDialog.findViewById(R.id.enrollButton);
                MaterialButton closeButton = courseAlertDialog.findViewById(R.id.closeButton);

                builder.setView(courseAlertDialog);

                final AlertDialog dialog = builder.create();

                enrollButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
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
        algorithm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View courseAlertDialog = inflater.inflate(R.layout.course_alertdialog,null);

                MaterialButton enrollButton = courseAlertDialog.findViewById(R.id.enrollButton);
                MaterialButton closeButton = courseAlertDialog.findViewById(R.id.closeButton);

                builder.setView(courseAlertDialog);

                final AlertDialog dialog = builder.create();

                enrollButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
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
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}