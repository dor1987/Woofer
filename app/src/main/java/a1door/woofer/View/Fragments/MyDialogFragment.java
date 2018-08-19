package a1door.woofer.View.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class MyDialogFragment extends android.support.v4.app.DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Woofer").setMessage("Food has been given").setPositiveButton("OK",null);

        Dialog dialog = alertDialogBuilder.create();

        return dialog;
    }

    public static MyDialogFragment newInstance() {

        Bundle args = new Bundle();

        MyDialogFragment fragment = new MyDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
