package com.example.makarcev_av.testwork;

import android.app.LoaderManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LoginIn extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static String LOG_TAG = "my_log";
    EditText login;
    EditText password;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        Log.d(LOG_TAG, "LoginIn work!!!");

        login = (EditText) findViewById(R.id.edlogin);
        password = (EditText) findViewById(R.id.edpassword);

        SharedPreferences loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        loginPrefsEditor.apply();
        login.setText(loginPreferences.getString("username", ""));
//        password.setText(loginPreferences.getString("password", ""));

    }

    public void Enter(View view) {
        Log.d(LOG_TAG, "Click Enter");
        login.setError(null);
        password.setError(null);

        String mLogin = login.getText().toString();
        String mPass = password.getText().toString();

        Boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(mPass)) {
            password.setError(getString(R.string.error_invalid_password));
            focusView = password;
            cancel = true;
        }
        if (TextUtils.isEmpty(mLogin)) {
            login.setError(getString(R.string.error_invalid_password));
            focusView = login;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            new ParseTask().execute();
        }
    }

    public void NextActivity(View view) {
        Intent intent = new Intent(this, ListUserGetAll.class);
        LoginIn.this.finish();
        startActivity(intent);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cursor.moveToNext();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    //    @Override
//    protected void onPause() {
//        loginPrefsEditor.putBoolean("saveLogin", false);
//        loginPrefsEditor.putString("username", login);
//        loginPrefsEditor.putString("password", password);
//        loginPrefsEditor.commit();
//        super.onPause();
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpsURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        String username = login.getText().toString();
        String userpassword = password.getText().toString();

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL("https://contact.taxsee.com/Contacts.svc/Hello?login=" + username + "&password=" + userpassword);
//                https://contact.taxsee.com/Contacts.svc/Hello?login=<login>&password=<pass>
                Log.d(LOG_TAG, String.valueOf(url));

                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder builder = new StringBuilder();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                resultJson = builder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            //вывод полученной строки
            Log.d(LOG_TAG, strJson);
            try {
                JSONObject jsonObject = new JSONObject(strJson);

                String mes = jsonObject.getString("Message");
                Boolean suc = jsonObject.getBoolean("Success");

                Log.d(LOG_TAG, "Сообщение " + mes + " Вход " + suc);

                if (!suc) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginIn.this);
                    builder.setTitle("Ошибка!")
                            .setMessage(mes)
                            .setIcon(R.drawable.ic_warning_black_24dp)
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                    Log.d(LOG_TAG, "Ошибка авторизации");

                } else {
                    Log.d(LOG_TAG, "Успешная авторизация");
                    String usernames = login.getText().toString();
                    String passwords = password.getText().toString();
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", usernames);
                    loginPrefsEditor.putString("password", passwords);
                    loginPrefsEditor.commit();
                    //запуск списка
                    NextActivity(null);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

