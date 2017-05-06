package app.connetick.com.connetick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list_view);
        myAdapter = new MyAdapter(this,getTickets());
        listView.setAdapter(myAdapter);


    }

    private ArrayList<Ticket> getTickets() {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.clear();

        Ticket mTicket = new Ticket();
        mTicket.setId(1000);
        mTicket.setSender("John Doe");
        mTicket.setSubject("Login issue ");
        mTicket.setBody("I need help, I cannot log into my computer, it keeps telling me account locked");
        mTicket.setAccepted(false);
        mTicket.setCompleted(false);
        tickets.add(mTicket);

        mTicket = new Ticket();
        mTicket.setId(1001);
        mTicket.setSender("Jim Bean");
        mTicket.setSubject("Network issue ");
        mTicket.setBody("My wireless connection isn't allowing me to use the VPN properly");
        mTicket.setAccepted(false);
        mTicket.setCompleted(false);
        tickets.add(mTicket);

        mTicket = new Ticket();
        mTicket.setId(1001);
        mTicket.setSender("Kate Hudson");
        mTicket.setSubject("Blue Screen of Death ");
        mTicket.setBody("Random line of code with a blue background, keeps showing up every time i try to work. ");
        mTicket.setAccepted(true);
        mTicket.setCompleted(false);
        tickets.add(mTicket);

        mTicket = new Ticket();
        mTicket.setId(1001);
        mTicket.setSender("CodeName Hotdog");
        mTicket.setSubject("Pizza ");
        mTicket.setBody("Hi tech support, anyone knows where i can find good pizza around here?");
        mTicket.setAccepted(true);
        mTicket.setCompleted(true);
        tickets.add(mTicket);

        return tickets;
    }
}
