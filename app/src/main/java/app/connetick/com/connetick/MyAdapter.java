package app.connetick.com.connetick;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kwasi on 5/5/2017.
 */

public class MyAdapter extends BaseAdapter {

    Context c;
    ArrayList<Ticket> tickets;
    LayoutInflater inflater;

    public MyAdapter(Context c, ArrayList<Ticket> tickets) {
        this.c = c;
        this.tickets = tickets;
    }

    //Get Total ticket number
    @Override
    public int getCount() {
        return tickets.size();
    }

    //Get a single ticket
    @Override
    public Object getItem(int position) {
        return tickets.get(position);
    }

    //ID
    @Override
    public long getItemId(int position) {
        return position;
    }
/**
    public interface EventListener{
        void onClick();
    }
**/
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null){
            convertView = inflater.inflate(R.layout.card_layout_model,null);
        }

        //Bind data to views
        final MyViewHolder holder = new MyViewHolder(convertView);
        holder.senderTV.setText(tickets.get(position).getSender());
        holder.subjectTV.setText(tickets.get(position).getSubject());

        //holder.colorChg;

        holder.acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.acceptBtn.setBackgroundColor(ContextCompat.getColor(c, R.color.colorPrimaryDark));
                //holder.acceptBtn.setBackgroundColor(c.getResources().getColor( R.color.colorPrimaryDark));
                Intent toBodyIntent = new Intent(c, BodyActivity.class);
                //c.startActivity(new Intent(c,BodyActivity.class));
                toBodyIntent.putExtra("ticketObj", (Serializable)tickets.get(position));
                c.startActivity(toBodyIntent);
            }
        });


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Intent toBody = new Intent(c,BodyActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(toBody);
            }
        });



        //Return a row
        return convertView;
    }
}
