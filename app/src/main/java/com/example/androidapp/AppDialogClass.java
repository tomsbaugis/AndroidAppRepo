package com.example.androidapp;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class AppDialogClass extends DialogFragment {

    private List<String> mSelectedItems;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mSelectedItems = new ArrayList<>();

        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("<4th> Group’s Dialog")
                .setMultiChoiceItems(R.array.members, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String[] items = getActivity().getResources().getStringArray(R.array.members);

                        if(isChecked){
                            mSelectedItems.add(items[which]);
                            Toast.makeText(getActivity(),"<"+items[which]+"> checked", Toast.LENGTH_SHORT).show();
                        } else if(mSelectedItems.contains(items[which])){
                            mSelectedItems.remove(items[which]);
                            Toast.makeText(getActivity(),"<"+items[which]+"> unchecked", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            //this is getting overrode
                    }
                })
                .setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "You closed dialog", Toast.LENGTH_SHORT).show();
                    }
                });

        return builder.create();
    }
}
