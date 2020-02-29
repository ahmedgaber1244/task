package luckysms.gaber.task.view.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import luckysms.gaber.task.AppSession;
import luckysms.gaber.task.R;
import luckysms.gaber.task.presenter.MainActivity_presenter;
import luckysms.gaber.task.utils.CurvedBottomNavigationView;
import luckysms.gaber.task.utils.progress_bar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private MainActivity_presenter presenter;
    public CurvedBottomNavigationView curvedBottomNavigationView;
    public RelativeLayout foreground;
    public ImageButton bellman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_view();
    }

    private void init_view() {
        AppSession.ProgressDialog = progress_bar.showLoadingDialog(this);
        AppSession.ProgressDialog.dismiss();
        foreground=findViewById(R.id.foreground);
        curvedBottomNavigationView = findViewById(R.id.customBottomBar);
        curvedBottomNavigationView.setItemIconTintList(null);
        bellman=(ImageButton)findViewById(R.id.bellman);
        presenter = new MainActivity_presenter(this);
        bellman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showbuttons();
            }
        });
    }
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
