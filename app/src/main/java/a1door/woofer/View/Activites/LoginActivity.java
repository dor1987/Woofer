package a1door.woofer.View.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import a1door.woofer.R;

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    Button register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);

         usernameEditText =findViewById(R.id.userNameEditText);
         passwordEditText = findViewById(R.id.passwordEditText);
        register = findViewById(R.id.loginBtn);
    }


    public void passwordEditTextClicked(View view) {
        passwordEditText.setText("");
    }

    public void onUserNameEditTextClicked(View view) {
        usernameEditText.setText("");
    }

    public void onLoginClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username",usernameEditText.getText().toString());
        startActivity(intent);
    }

    public void onSignInClicked(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
