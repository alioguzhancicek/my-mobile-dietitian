package com.alioguzhancicek.mymobiledietician.api;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.alioguzhancicek.mymobiledietician.MainActivity;

import java.lang.ref.WeakReference;

public class GetUserInfoAsyncTask extends AsyncTask<Long, Void, ResponseUserInfo> {

    private WeakReference<MainActivity> mainActivityWeakReference;

    public GetUserInfoAsyncTask(MainActivity mainActivity) {
        mainActivityWeakReference = new WeakReference<>(mainActivity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MainActivity mainActivity = mainActivityWeakReference.get();
        //mainActivity.progressDialog.show();
    }

    @Override
    protected ResponseUserInfo doInBackground(Long... id) {
        UserInfoClient userInfoClient = new UserInfoClient();
        return userInfoClient.getUserInfo(id[0]);
    }

    @Override
    protected void onPostExecute(ResponseUserInfo userInfo) {
        super.onPostExecute(userInfo);
        MainActivity mainActivity = mainActivityWeakReference.get();
        if (userInfo!=null) {
            // mainActivity.getNewsButton.setEnabled(false);
            Context context = mainActivity.getApplicationContext();
            CharSequence text = "User Info Fetched !";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Context context = mainActivity.getApplicationContext();
            CharSequence text = "ERROR";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }

//        if (mainActivity.progressDialog.isShowing()) {
//            mainActivity.progressDialog.hide();
//        }
    }
}
