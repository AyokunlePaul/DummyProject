package i.am.eipeks.ilab;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PasswordReset extends AppCompatActivity
implements View.OnClickListener, DialogInterface.OnClickListener{

    private Button resetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        resetPasswordButton = (Button)findViewById(R.id.reset_password_button);
        resetPasswordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.reset_password_button:
                AlertDialog confirmationDialog =
                        new AlertDialog.Builder(this).create();
                confirmationDialog.setTitle("Reset Password?");
                confirmationDialog.setButton(
                        AlertDialog.BUTTON_POSITIVE,
                        "RESET", this
                );
                confirmationDialog.setButton(
                        AlertDialog.BUTTON_NEGATIVE,
                        "CANCEL", this);
                confirmationDialog.show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch(which){
            case AlertDialog.BUTTON_POSITIVE:
                Toast toast = Toast.makeText(this, "Reset Successful", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                dialog.dismiss();
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                dialog.dismiss();
                break;
        }
    }
}
