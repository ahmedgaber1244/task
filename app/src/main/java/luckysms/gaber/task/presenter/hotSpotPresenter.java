package luckysms.gaber.task.presenter;

import android.content.Context;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import luckysms.gaber.task.data.Adapter.HotSpotDetails;
import luckysms.gaber.task.data.Model.HotSpot;

public class hotSpotPresenter {
    private HotSpotDetails adapter;
    Context context;
    List<HotSpot> details;
    RecyclerView catDetails;

    public hotSpotPresenter(Context context, List<HotSpot> hotSpots, RecyclerView catDetails) {
        this.context = context;
        this.details = hotSpots;
        this.catDetails = catDetails;
        setdata(hotSpots);
    }

    private void setdata(List<HotSpot> data) {
        adapter = new HotSpotDetails(context,data);
        catDetails.setAdapter(adapter);
    }
}
