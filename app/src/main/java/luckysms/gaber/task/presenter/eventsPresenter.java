package luckysms.gaber.task.presenter;

import android.content.Context;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import luckysms.gaber.task.data.Adapter.HotSpotDetails;
import luckysms.gaber.task.data.Adapter.eventsDetails;
import luckysms.gaber.task.data.Model.HotSpot;

public class eventsPresenter {
    private eventsDetails adapter;
    Context context;
    List<Object> details;
    RecyclerView catDetails;
    public eventsPresenter(Context context, List<Object> events, RecyclerView catDetails) {
        this.context = context;
        this.details = events;
        this.catDetails = catDetails;
        setdata(events);
    }
    private void setdata(List<Object> data) {
        adapter = new eventsDetails(context,data);
        catDetails.setAdapter(adapter);
    }
}
