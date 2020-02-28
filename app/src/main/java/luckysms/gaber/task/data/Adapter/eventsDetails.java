package luckysms.gaber.task.data.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import luckysms.gaber.task.AppSession;
import luckysms.gaber.task.R;
import luckysms.gaber.task.data.Model.HotSpot;

public class eventsDetails extends RecyclerView.Adapter<eventsDetails.MyViewHolder> {
    private Context context;
    private List<Object> list = new ArrayList<>();

    public eventsDetails(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public eventsDetails.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        eventsDetails.MyViewHolder myViewHolder = new eventsDetails.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(eventsDetails.MyViewHolder holder, int position) {
        Object data=list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView cardName,cardDesc;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            cardName = (TextView) itemView.findViewById(R.id.cardName);
            cardDesc = (TextView) itemView.findViewById(R.id.cardDesc);
        }
    }
}
