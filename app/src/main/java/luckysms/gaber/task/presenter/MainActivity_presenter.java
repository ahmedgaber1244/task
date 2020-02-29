package luckysms.gaber.task.presenter;

import android.Manifest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import luckysms.gaber.task.R;
import luckysms.gaber.task.view.Activity.MainActivity;
import luckysms.gaber.task.view.Fragment.home;

import static luckysms.gaber.task.AppSession.change_language;

public class MainActivity_presenter {
    private MainActivity mainActivity;
    private Fragment fragment;
    public MainActivity_presenter(final MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        if (fragment instanceof home) {
            Toast.makeText(mainActivity.getApplicationContext(),mainActivity.getResources().getString(R.string.you_already_home),Toast.LENGTH_LONG).show();
        }else {
            fragment = new home();
            display_fragment(fragment, R.id.mainFrame);
        }
        mainActivity.curvedBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                if (fragment instanceof home) {
                                    Toast.makeText(mainActivity.getApplicationContext(),mainActivity.getResources().getString(R.string.you_already_home),Toast.LENGTH_LONG).show();
                                }else {
                                    fragment = new home();
                                    display_fragment(fragment, R.id.mainFrame);
                                }
                                item.setChecked(true);
                                break;

                            case R.id.search:
                                item.setChecked(true);
                                break;
                            case R.id.bellman:
                                showbuttons();
                                break;
                            case R.id.notification:
                                item.setChecked(true);
                                break;
                            case R.id.profile:
                                item.setChecked(true);
                                break;



                        }
                        return false;
                    }
                });
        check_forall_permissions();
    }
    private void check_forall_permissions(){
        Dexter.withActivity(mainActivity)
                .withPermissions(
                        Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.ACCESS_NETWORK_STATE
                )
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            // do you work now
                            change_language();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // permission is denied permenantly, navigate user to app settings
                            mainActivity.finish();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();

                    }


                })
                .onSameThread()
                .check();
    }
    private void display_fragment(Fragment fragment, int frame_id) {
        mainActivity.getSupportFragmentManager().beginTransaction()
                .replace(frame_id, fragment)
                .commit();
    }
    private void updateNavigationBarState(int actionId){
        Menu menu = mainActivity.curvedBottomNavigationView.getMenu();

        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            item.setChecked(item.getItemId() == actionId);
        }
    }

    public void showbuttons() {
        if (mainActivity.foreground.getVisibility()== View.VISIBLE){
            mainActivity.foreground.setVisibility(View.GONE);
        }else {
            mainActivity.foreground.setVisibility(View.VISIBLE);
        }
    }
}
