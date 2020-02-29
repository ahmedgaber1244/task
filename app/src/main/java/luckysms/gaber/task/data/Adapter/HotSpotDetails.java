package luckysms.gaber.task.data.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import luckysms.gaber.task.AppSession;
import luckysms.gaber.task.R;
import luckysms.gaber.task.data.Model.Attraction;
import luckysms.gaber.task.data.Model.HotSpot;

public class HotSpotDetails extends RecyclerView.Adapter<HotSpotDetails.MyViewHolder> {
    private Context context;
    private List<HotSpot> list = new ArrayList<>();

    public HotSpotDetails(Context context, List<HotSpot> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public HotSpotDetails.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HotSpotDetails.MyViewHolder myViewHolder = new HotSpotDetails.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HotSpotDetails.MyViewHolder holder, int position) {
        HotSpot data=list.get(position);
        if (data.getPhotos()!=null&&!data.getPhotos().isEmpty()) {
            Picasso.with(context)
                    .load(data.getPhotos().get(0))
                    .fit()
                    .into(holder.img, new Callback() {
                        @Override
                        public void onSuccess() {
                        }

                        @Override
                        public void onError() {
                        }
                    });
        }
        if (AppSession.language.equalsIgnoreCase("ar")&&data.getArabicDescription()!=null&&!data.getArabicDescription().isEmpty()){
            if (data.getArabicDescription().length() > 40) {
                holder.cardDesc.setText(data.getArabicDescription().substring(0,37)+"...");
            }else {
                holder.cardDesc.setText(data.getArabicDescription());
            }
        }else {
            if (data.getDescription()!=null&&data.getDescription().length() > 40) {
                holder.cardDesc.setText(data.getDescription().substring(0,37)+"...");
            }else {
                holder.cardDesc.setText(data.getDescription());
            }
        }

        if (AppSession.language.equalsIgnoreCase("ar")&&data.getArabicName()!=null&&!data.getArabicName().isEmpty()){
            if (data.getArabicName().length() > 30) {
                holder.cardName.setText(data.getArabicName().substring(0,27)+"...");
            }else {
                holder.cardName.setText(data.getArabicName());
            }
        }else {
            if (data.getName().length() > 30) {
                holder.cardName.setText(data.getName().substring(0,27)+"...");
            }else {
                holder.cardName.setText(data.getName());
            }
        }
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
