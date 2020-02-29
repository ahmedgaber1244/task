package luckysms.gaber.task.presenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingDeque;

import androidx.annotation.NonNull;
import luckysms.gaber.task.AppSession;
import luckysms.gaber.task.R;
import luckysms.gaber.task.data.Adapter.HotSpotDetails;
import luckysms.gaber.task.data.Adapter.attractionsDetails;
import luckysms.gaber.task.data.Adapter.eventsDetails;
import luckysms.gaber.task.data.Model.dataModel;
import luckysms.gaber.task.data.Model.response_model;
import luckysms.gaber.task.view.Fragment.home;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static luckysms.gaber.task.AppSession.Api;

public class home_presenter {
    private home home;
    private attractionsDetails attractionsAdapter;
    private eventsDetails eventsAdapter;
    private HotSpotDetails HotSpotAdapter;
    private FusedLocationProviderClient mFusedLocationClient;
    double lat,lng;
    public home_presenter(home home) {
        this.home = home;
        ask_for_location();
        searchItems();
    }

    public void searchItems() {

        if (AppSession.isInternetAvailable()) {
            Call<response_model> call = Api.data();
            AppSession.ProgressDialog.show();
            call.enqueue(new Callback<response_model>() {
                @Override
                public void onResponse(Call<response_model> stlist, Response<response_model> response) {
                    //Dismissing the loading progressbar
                    if (response.isSuccessful()) {
                        AppSession.ProgressDialog.dismiss();
                        response_model res = response.body();
                        Log.w("asdadasd", new Gson().toJson(response.body()));
                        setdata(res.getData());

                    } else {
                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());
                            Log.w("asdasdasdasdads", jObjError.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<response_model> call, Throwable t) {
                    AppSession.ProgressDialog.dismiss();
                    t.printStackTrace();
                }
            });
        } else {
            AppSession.show_message(home.getActivity(), home.getResources().getString(R.string.check_your_internet_connectivity), true);
        }
    }

    private void setdata(dataModel data) {
        if (data.getHotSpots()!=null&&!data.getHotSpots().isEmpty()){
            home.HotSpots_view_all.setVisibility(View.VISIBLE);
            home.HotSpots_nodata.setVisibility(View.GONE);
            home.HotSpotsRecycler.setVisibility(View.VISIBLE);
            HotSpotAdapter = new HotSpotDetails(home.getActivity(), data.getHotSpots());
            home.HotSpotsRecycler.setAdapter(HotSpotAdapter);
        }else {
            home.HotSpots_view_all.setVisibility(View.GONE);
            home.HotSpots_nodata.setVisibility(View.VISIBLE);
            home.HotSpotsRecycler.setVisibility(View.GONE);
        }

        if (data.getAttractions()!=null&&!data.getAttractions().isEmpty()){
            home.attarctions_view_all.setVisibility(View.VISIBLE);
            home.attractions_nodata.setVisibility(View.GONE);
            home.attarctionsRecycler.setVisibility(View.VISIBLE);
            attractionsAdapter = new attractionsDetails(home.getActivity(), data.getAttractions());
            home.attarctionsRecycler.setAdapter(attractionsAdapter);
        }else {
            home.attarctions_view_all.setVisibility(View.GONE);
            home.attractions_nodata.setVisibility(View.VISIBLE);
            home.attarctionsRecycler.setVisibility(View.GONE);
        }
        if (data.getEvents()!=null&&!data.getEvents().isEmpty()){
            home.events_view_all.setVisibility(View.VISIBLE);
            home.events_nodata.setVisibility(View.GONE);
            home.eventsRecycler.setVisibility(View.VISIBLE);
            eventsAdapter = new eventsDetails(home.getActivity(), data.getEvents());
            home.eventsRecycler.setAdapter(eventsAdapter);
        }else {
            home.events_view_all.setVisibility(View.GONE);
            home.events_nodata.setVisibility(View.VISIBLE);
            home.eventsRecycler.setVisibility(View.GONE);
        }

    }
    private void ask_for_location(){
        Log.w("klsdasdasdsd","not working");
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        Task<LocationSettingsResponse> result =
                LocationServices.getSettingsClient(home.getActivity()).checkLocationSettings(builder.build());



        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    // All location settings are satisfied. The client can initialize location
                    // requests here.
                    Log.w("klsdasdasdsd","working");

                    request_location();
                } catch (ApiException exception) {
                    switch (exception.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied. But could be fixed by showing the
                            // user a dialog.

                            try {
                                // Cast to a resolvable exception.
                                ResolvableApiException resolvable = (ResolvableApiException) exception;
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                resolvable.startResolutionForResult(
                                        home.getActivity(),
                                        LocationRequest.PRIORITY_HIGH_ACCURACY);


                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            } catch (ClassCastException e) {
                                // Ignore, should be an impossible error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way to fix the
                            // settings so we won't show the dialog.
                            break;
                    }
                }
            }
        });
    }
    @SuppressLint("MissingPermission")
    public void request_location(){

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(home.getActivity());
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener( home.getActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            lat=location.getLatitude();
                            lng=location.getLongitude();
                            Geocoder geocoder = new Geocoder(home.getActivity(), Locale.getDefault());
                            try {
                                List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
                                String distirct = addresses.get(0).getAdminArea();
                                String stateName = addresses.get(0).getAddressLine(1);
                                String countryName = addresses.get(0).getCountryName();

                                home.location.setText(distirct+"-"+countryName);
                            }catch (Exception e){

                            }

                        }
                    }
                });
    }

}
