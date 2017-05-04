package app.connetick.com.connetick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    Button toSignInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
/**
        toSignInBtn = (Button) findViewById(R.id.to_sign_in_btn);

        toSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toSignInFormIntent = new Intent(SignUpActivity.this, Login.class);
                startActivity(toSignInFormIntent);
            }
        }); **/

        findViewById(R.id.signup_btn_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.signin_btn_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,StartActivity.class));
            }
        });
    }
}
