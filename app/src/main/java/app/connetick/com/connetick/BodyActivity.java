package app.connetick.com.connetick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BodyActivity extends AppCompatActivity {

    TextView senderTVB, bodyTVB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        senderTVB = (TextView) findViewById(R.id.sender_tv_body);
        bodyTVB = (TextView) findViewById(R.id.body_tv_body);

        Intent intent = getIntent();
        Ticket ticket = (Ticket)intent.getSerializableExtra("ticketObj");
        //System.out.print(ticket.getSender());

        senderTVB.setText(ticket.getSender().toString());
        bodyTVB.setText(ticket.getBody().toString());





        findViewById(R.id.complete_task_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BodyActivity.this,CompletionFormActivity.class));
            }
        });
    }
}
