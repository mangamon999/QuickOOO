package inpheller.com.quickooo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by brunopinheiro on 6/18/15.
 */
public class MessageInputDialogFragment extends DialogFragment {

    private MessageInputListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View dialogView = inflater.inflate(R.layout.message_input_dialog, null);
        builder.setView(dialogView)
                // Add action buttons
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText messageEditText = (EditText) dialogView.findViewById(R.id.message);
                        MessageInputDialogFragment.this.listener.messageCreated(messageEditText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MessageInputDialogFragment.this.getDialog().cancel();
                        MessageInputDialogFragment.this.listener.messageCreationCanceled();
                    }
                });
        return builder.create();
    }

    public void setListener(MessageInputListener listener) {
        this.listener = listener;
    }

    public interface MessageInputListener {
        void messageCreated(String newMessage);
        void messageCreationCanceled();
    }
}
