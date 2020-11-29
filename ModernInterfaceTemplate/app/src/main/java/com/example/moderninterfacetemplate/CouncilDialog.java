package com.example.moderninterfacetemplate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.example.moderninterfacetemplate.QuizActivity;

public class CouncilDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("View Town Councils")
                .setMessage("Having issues with contacting your local town council? Not to familiar with their contact details? Use this function to find your town council and contact them regarding serious dengue issues")
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://www.epbt.gov.my/osc/PBT2_index.cfm?Neg=00&Taraf=0"));
                        startActivity(browserIntent);
                    }
                });

        return builder.create();

    }
}
