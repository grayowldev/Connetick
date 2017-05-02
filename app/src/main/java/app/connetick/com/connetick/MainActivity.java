package app.connetick.com.connetick;

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
    Button testBtn;
    EditText editTextView;
    TextView areaView;
    int portNumber = 4200;


    DataOutputStream dataOut = null;
    DataInputStream dataIn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = (Button) findViewById(R.id.test_btn);
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
                area.execute(radius);
                areaView.setText("");
                areaView.setText("radius is: " + radius + '\n');
                areaView.append("area is: " + area + '\n');




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

    public class NetworkRunner extends AsyncTask<Double,String, Double>{

        @Override
        protected Double doInBackground(Double... doubles) {
            try{
                Socket socket = new Socket("localHost",portNumber);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());

                double radius = doubles[0];

                dataOut.writeDouble(radius);
                dataOut.flush();

                double area = dataIn.readDouble();
                return area;

            }
            catch (Exception e){

            }
            return 9.87;
        }
    }

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
