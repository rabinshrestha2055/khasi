package com.example.bokabazar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class InputDialog extends AppCompatDialogFragment {
    private EditText Username;
    private EditText Email;
    private EditText Contact;
    private EditText Location;
    private InputeDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_edit, null);

        builder.setView(view)
                .setTitle("User Details")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = Username.getText().toString();
                        String email = Email.getText().toString();
                        String contact = Contact.getText().toString();
                        String address = Location.getText().toString();
                        listener.applyTexts(username,email,contact,address );
                    }

                });

             Username = view.findViewById(R.id.edit_username);
             Email = view.findViewById(R.id.edit_email);
             Contact = view.findViewById(R.id.edit_contact);
            Location = view.findViewById(R.id.edit_location);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (InputeDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implements InputeDialogListener");
        }
    }

    public interface InputeDialogListener {
        void applyTexts(String username, String email,String contact,String address);
    }
}
