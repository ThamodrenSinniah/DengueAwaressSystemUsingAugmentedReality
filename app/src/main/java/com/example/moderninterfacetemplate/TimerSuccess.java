package com.example.moderninterfacetemplate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class TimerSuccess extends AppCompatDialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Good Job!")
                .setMessage("You managed to shoot all of the Aedes Mosquitoes before the timer ends!")
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
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
