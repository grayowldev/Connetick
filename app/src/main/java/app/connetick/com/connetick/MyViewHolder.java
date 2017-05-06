package app.connetick.com.connetick;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kwasi on 5/5/2017.
 */

public class MyViewHolder implements View.OnClickListener{

    TextView senderTV, subjectTV;
    Button acceptBtn;
    LinearLayout colorChg;
    ItemClickListener itemClickListener;

    public MyViewHolder(View v) {
        senderTV = (TextView) v.findViewById(R.id.sender_tv);
        subjectTV = (TextView) v.findViewById(R.id.subject_tv);
        acceptBtn = (Button) v.findViewById(R.id.accept_btn);
        colorChg = (LinearLayout) v.findViewById(R.id.color_chg);

        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}
