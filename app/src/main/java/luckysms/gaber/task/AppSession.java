package luckysms.gaber.task;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

import com.jakewharton.processphoenix.ProcessPhoenix;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import luckysms.gaber.task.data.Network.ApiRequests;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppSession extends Application {
    public static String language;
    public static String Base_url = "http://bellman-bd.restart-technology.com";
    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();
    public static Retrofit adapter = new Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();
    public static ApiRequests Api = adapter.create(ApiRequests.class);
    public static android.app.ProgressDialog ProgressDialog;
    private static Context context;

    @SuppressLint("NewApi")
    public static void change_language(String lang_code) {
        AppSession.language = lang_code;
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(lang_code));
        res.updateConfiguration(conf, dm);
        ProcessPhoenix.triggerRebirth(context);
    }

    @SuppressLint("NewApi")
    public static void change_language() {
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(AppSession.language.trim().toLowerCase()));
        res.updateConfiguration(conf, dm);
    }

    @SuppressLint("NewApi")
    public static void show_message(Context context, String text, boolean warning) {

            AlertDialog alert = new AlertDialog.Builder(context, R.style.MyAlertDialogTheme)

                .setMessage(text)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .show();
        if (warning) {
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle(context.getResources().getText(R.string.Warning));
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        language=getSharedPreferences("session",MODE_PRIVATE).getString("language",getResources().getConfiguration().locale.getLanguage());

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        change_language();
    }


    @SuppressLint("MissingPermission")
    public static boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}
