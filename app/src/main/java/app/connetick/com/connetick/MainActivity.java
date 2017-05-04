package app.connetick.com.connetick;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button testBtn, recycBtn, toCard;
    EditText editTextView;
    TextView areaView;
    int portNumber = 4200;
    String serverIP = "192.168.1.16";


    DataOutputStream dataOut = null;
    DataInputStream dataIn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = (Button) findViewById(R.id.test_btn);
        recycBtn = (Button) findViewById(R.id.recyc_button);
        toCard = (Button) findViewById(R.id.to_card_model);
        editTextView = (EditText) findViewById(R.id.text_view_test);
        areaView = (TextView) findViewById(R.id.area_view);



        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/**
                new Thread(){
                    public void run(){
                    }
                }.start();
**/
                double radius = Double.parseDouble(editTextView.getText().toString().trim());
                NetworkRunner area = new NetworkRunner();

                areaView.setText("");
                //areaView.setText("radius is: " + radius + '\n');
                area.execute(radius);
                //areaView.append("area is: " + area + '\n');

            }
        });

        recycBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecycActNtt = new Intent(MainActivity.this, RecycTest.class);
                startActivity(toRecycActNtt);
            }
        });

        toCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.card_layout_model);
            }
        });
/**
        try {
            Socket socket = new Socket("192.168.1.3", portNumber);
            System.out.println("local port: " + socket.getLocalPort());
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
        }
        catch (Exception e){
            areaView.append(e.toString() + '\n');
        }
 **/
    }

    public class NetworkRunner extends AsyncTask<Double,String, String>{

        @Override
        protected String doInBackground(Double... doubles) {
            try{
                Socket socket = new Socket(serverIP,portNumber);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());

                double radius = doubles[0];

                dataOut.writeDouble(radius);
                dataOut.flush();

                double area = dataIn.readDouble();
                String stringArea = String.valueOf(area);
                //return area;
                return stringArea;

            }
            catch (Exception e){
                System.out.println(e);
                return null;
            }

        }

        @Override
        protected void onPostExecute(String aString) {
            super.onPostExecute(aString);
            areaView.append("area is: " + aString);
        }
    }

    //public String networkArea(){

        //return null;
    //}

/**
        @Override
        protected String doInBackground(Double... doubles) {
            try {
                
                Socket socket = new Socket("192.168.1.3", portNumber);
                System.out.println("local port: " + socket.getLocalPort());
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                //double radius = Double.parseDouble(editTextView.getText().toString().trim());

                dataOut.writeDouble(radius);
                dataOut.flush();

                double area = dataIn.readDouble();
                //areaView.setText("");
                //areaView.setText("radius is: " + radius + '\n');
                //areaView.append("area is: " + area + '\n');

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

**/



}
