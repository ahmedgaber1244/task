package luckysms.gaber.task.view.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.LocationRequest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import luckysms.gaber.task.R;
import luckysms.gaber.task.presenter.home_presenter;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static luckysms.gaber.task.AppSession.change_language;

public class home extends Fragment {
    public RecyclerView attarctionsRecycler,eventsRecycler,HotSpotsRecycler;
    public Button HotSpots_view_all,events_view_all,attarctions_view_all;
    public TextView HotSpots_nodata,events_nodata,attractions_nodata,location;
    private View view;
    private home_presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        change_language();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        view = inflater.inflate(R.layout.home   , container, false);
        init_views();
        return view;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        change_language();
    }

    private void init_views() {
        attarctionsRecycler=view.findViewById(R.id.attarctionsRecycler);
        eventsRecycler=view.findViewById(R.id.eventsRecycler);
        HotSpotsRecycler=view.findViewById(R.id.HotSpotsRecycler);
        HotSpots_view_all=(Button)view.findViewById(R.id.HotSpots_view_all);
        events_view_all=(Button)view.findViewById(R.id.events_view_all);
        attarctions_view_all=(Button)view.findViewById(R.id.attarctions_view_all);
        HotSpots_nodata=(TextView) view.findViewById(R.id.HotSpots_nodata);
        events_nodata=(TextView) view.findViewById(R.id.events_nodata);
        attractions_nodata=(TextView) view.findViewById(R.id.attractions_nodata);
        location=(TextView) view.findViewById(R.id.location);
        presenter=new home_presenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.request_location();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case LocationRequest.PRIORITY_HIGH_ACCURACY:
                switch (resultCode) {
                    case RESULT_OK:
                        // All required changes were successfully made
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                presenter.request_location();
                            }
                        }, 4000);
                        break;
                    case RESULT_CANCELED:
                        // The user was asked to change settings, but chose not to

                        break;
                    default:
                        break;
                }
                break;
        }
    }
}
