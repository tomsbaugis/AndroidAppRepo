package com.example.androidapp;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppDialogClass extends DialogFragment {

    private List<String> mSelectedItems;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mSelectedItems = new ArrayList<>();

        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("<4th> Group’s Dialog")
            .setMultiChoiceItems(R.array.members, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    String[] items = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.members);

                    if(isChecked){
                        mSelectedItems.add(items[which]);
                        Toast.makeText(getActivity(),"<"+items[which]+"> checked", Toast.LENGTH_SHORT).show();
                    } else if(mSelectedItems.contains(items[which])){
                        mSelectedItems.remove(items[which]);
                        Toast.makeText(getActivity(),"<"+items[which]+"> unchecked", Toast.LENGTH_SHORT).show();
                    }
                }
            })
            .setPositiveButton("ok", null)
            .setNegativeButton("close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(), "You closed dialog", Toast.LENGTH_SHORT).show();
                }
            });
        AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You clicked OK", Toast.LENGTH_SHORT).show();
            }
        });
        return dialog;
    }
}
