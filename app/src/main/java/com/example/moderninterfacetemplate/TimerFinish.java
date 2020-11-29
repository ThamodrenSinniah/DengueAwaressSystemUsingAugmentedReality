package com.example.moderninterfacetemplate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class TimerFinish extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Better Luck Next Time")
                .setMessage("You ran out of time! Want to try again?")
                .setPositiveButton("Try Gain", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent browserIntent = new Intent(getContext(),AugmentedGame.class);
                        startActivity(browserIntent);
                    }
                })
                .setNegativeButton("AR Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent browserIntent = new Intent(getContext(),AugmentedList.class);
                        startActivity(browserIntent);
                    }
                });




        return builder.create();

    }


}
