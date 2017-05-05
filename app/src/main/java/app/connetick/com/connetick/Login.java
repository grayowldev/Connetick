package app.connetick.com.connetick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button signUpBtn,signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpBtn = (Button)findViewById(R.id.sign_up_btn);
        signInBtn = (Button)findViewById(R.id.sign_in_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toSignUpFormIntent = new Intent(Login.this, SignUpActivity.class);
                startActivity(toSignUpFormIntent);
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent loginIntent = new Intent(Login.this, ListActivity.class);
                startActivity(loginIntent);
            }
        });

        findViewById(R.id.forgot_pass_btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,ForgotPasswordActivity.class));
            }
        });

        findViewById(R.id.signin_google_btn_signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,ListActivity.class));
            }
        });
    }
}
