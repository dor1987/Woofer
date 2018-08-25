package a1door.woofer.View.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import a1door.woofer.R;

public class SignInActivity  extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    EditText mailEditText;
    EditText wooferIdEditText;

    Button registerBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity_layout);

        usernameEditText =findViewById(R.id.wooferUserNameRegisterEditText);
        passwordEditText = findViewById(R.id.wooferPasswordRegisterEditText);
        mailEditText = findViewById(R.id.wooferEmaillRegisterEditText);
        wooferIdEditText = findViewById(R.id.wooferIdRegisterEditText);
        registerBtn = findViewById(R.id.registerBtn);
    }


    public void onUserNameRegisterEditTextClicked(View view) {
        usernameEditText.setText("");
    }

    public void passwordRegisterEditTextClicked(View view) {
        passwordEditText.setText("");
    }

    public void eMailRegisterEditTextClicked(View view) {
        mailEditText.setText("");
    }

    public void wooferIdRegisterEditTextClicked(View view) {
        wooferIdEditText.setText("");
    }

    public void onRegisterClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username",usernameEditText.getText().toString());
        startActivity(intent);
    }
}