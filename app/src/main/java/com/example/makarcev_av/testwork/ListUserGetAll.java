package com.example.makarcev_av.testwork;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.makarcev_av.testwork.POJO.Departments;
import com.example.makarcev_av.testwork.POJO.Employees;
import com.example.makarcev_av.testwork.POJO.GetAll;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import static com.example.makarcev_av.testwork.R.string.username;

public class ListUserGetAll extends AppCompatActivity implements ListFragmentFirst.OnSelectedItem {

    public static String LOG_TAG = "my_log";
    public List<GetAll> getAllItems = new ArrayList<>();
    public List<Departments> getDepartment = new ArrayList<>();
    public List<Employees> getEmployee = new ArrayList<>();

    SharedPreferences.Editor loginPrefsEditor;
    String username;
    String userpassword;
    boolean saveLogin;
    String[] vseDep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_getall);
        Log.d(LOG_TAG, "ListUserGetAll work!!!");

        //Получение данных из файла
        SharedPreferences loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        loginPrefsEditor.apply();
        saveLogin = (loginPreferences.getBoolean("saveLogin", false));
        username = (loginPreferences.getString("username", ""));
        userpassword = (loginPreferences.getString("password", ""));

        //Проверка наличия данных
        if (!saveLogin) {
            Intent intent = new Intent(this, LoginIn.class);
            startActivity(intent);
            ListUserGetAll.this.finish();
        } else {
            new ParseList().execute();
        }

        //Программное добавление фрагмента в контейнер
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // Создаем и добавляем первый фрагмент
        ListFragmentFirst listFragmentFirst = new ListFragmentFirst();
        ft.add(R.id.containerListFragmentGetAll, listFragmentFirst, "listFragment1");
        // Подтверждаем операцию
        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onLogoutMenuClick(MenuItem item) {
        Log.d(LOG_TAG, "LogOut");
        Intent intent = new Intent(this, LoginIn.class);

        loginPrefsEditor.putBoolean("saveLogin", false);
        loginPrefsEditor.putString("username", username);
        loginPrefsEditor.putString("password", "");
        loginPrefsEditor.commit();

        ListUserGetAll.this.finish();
        startActivity(intent);
    }

    public void onSettingMenuClick(MenuItem item) {
//        Toast toast = Toast.makeText(getApplicationContext(), R.string.action_settings, Toast.LENGTH_SHORT);
//        toast.show();
        Intent intent = new Intent(this, InfoEmployee.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(int itemIndex) {
        Log.d(LOG_TAG, String.valueOf(itemIndex));
//        if (itemIndex % 3 == 0) {

//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:81234567890"));
//
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            startActivity(callIntent);

//            Intent intent = new Intent(this, ListUserDep.class);
//            intent.putExtra("itemIndex", itemIndex);
//            startActivity(intent);


//            Toast toast = Toast.makeText(getApplicationContext(),"Отдел пустой",Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.show();
//        } else {
            Intent intent = new Intent(this, ListUserDep.class);
            intent.putExtra("itemIndex", itemIndex);
            startActivity(intent);
//        }
    }

    private class ParseList extends AsyncTask<Void, Void, String> {

        HttpsURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(Void... params) {
            try {

                URL url = new URL("https://contact.taxsee.com/Contacts.svc/GetAll?login=" + username + "&password=" + userpassword);
//                https://contact.taxsee.com/Contacts.svc/Hello?login=<login>&password=<pass>
                Log.d(LOG_TAG, String.valueOf(url));

                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();//получение данных из разных источников
                StringBuilder builder = new StringBuilder();//Класс StringBuffer представляет расширяемые и доступные для изменений последовательности символов, позволяя вставлять символы и подстроки в существующую строку и в любом месте

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);//Метод соединяет представление любого другого типа данных
                }

                resultJson = builder.toString();

//TODO

//                JSONObject jsonAll = new JSONObject(resultJson);
//                Integer idAll = jsonAll.getInt("ID");
//                String nameAll = jsonAll.getString("Name");
//                Log.d(LOG_TAG, String.valueOf(idAll) + " " + nameAll);
//                JSONArray depAll = jsonAll.getJSONArray("Departments");
//
//                vseDep = new String[depAll.length()];
//
//                for (int i = 0; i < depAll.length(); i++) { //all
//                    JSONObject dep0 = depAll.getJSONObject(i);
//                    Integer idDep = dep0.getInt("ID");
//                    String nameDep = dep0.getString("Name");
//                    vseDep[i] = dep0.getString("Name");
//                    Log.d(LOG_TAG, "Здание " + i + ": " + idDep + " " + nameDep);
//
//                    if (dep0.has("Employees")) {//первые сотрудники
//                        JSONArray empAll = dep0.getJSONArray("Employees");
//                        for (int n = 0; n < empAll.length(); n++) {
//                            JSONObject emp0 = empAll.getJSONObject(n);
//                            Integer idEmp = emp0.getInt("ID");
//                            String nameEmp = emp0.getString("Name");
//                            String title = emp0.getString("Title");
//                            String email = emp0.getString("Email");
//                            String phone = emp0.getString("Phone");
//                            Log.d(LOG_TAG, "    Сотрудник " + n + ": " + idEmp + " " + nameEmp + " " + title + " " + email + " " + phone);
//                        }
//                    } //первые сотрудники
//
//                    if (dep0.has("Departments")) {//отделы
//                        JSONArray dep1 = dep0.getJSONArray("Departments");
//                        for (int m = 0; m < dep1.length(); m++) {
//                            JSONObject dep2 = dep1.getJSONObject(m);
//                            Integer idDep1 = dep2.getInt("ID");
//                            String nameDep1 = dep2.getString("Name");
//                            Log.d(LOG_TAG, "    Отдел " + m + ": " + idDep1 + " " + nameDep1);
//
//                            if (dep2.has("Employees")) {//сотрудники в отделах
//                                JSONArray emp3 = dep2.getJSONArray("Employees");
//                                for (int x = 0; x < emp3.length(); x++) {
//                                    JSONObject emp4 = emp3.getJSONObject(x);
//                                    Integer idEmp1 = emp4.getInt("ID");
//                                    String nameEmp1 = emp4.getString("Name");
//                                    String title1 = emp4.getString("Title");
////                                    String phone1 = emp4.getString("Phone");
//                                    if (emp4.has("Email")) {
//                                        String email1 = emp4.getString("Email");
//                                        Log.d(LOG_TAG, "        Сотрудник " + x + ": " + idEmp1 + " " + nameEmp1 + " " + title1 + " " + email1);
//                                    } else {
//                                        Log.d(LOG_TAG, "        Сотрудник " + x + ": " + idEmp1 + " " + nameEmp1 + " " + title1);
//                                    }
//                                }
//                            }//сотрудники в отделах
//
//                            if (dep2.has("Departments")) {//отделы в отделах
//                                JSONArray dep123 = dep2.getJSONArray("Departments");
//                                for (int y = 0; y < dep123.length(); y++) {
//                                    JSONObject dep321 = dep123.getJSONObject(y);
//                                    Integer idDep123 = dep321.getInt("ID");
//                                    String nameDep123 = dep321.getString("Name");
//                                    Log.d(LOG_TAG, "        Подотдел " + y + ": " + idDep123 + " " + nameDep123);
//
//                                    if (dep321.has("Employees")) {//сотрудники в Подотделах
//                                        JSONArray emp321 = dep321.getJSONArray("Employees");
//                                        for (int x = 0; x < emp321.length(); x++) {
//                                            JSONObject emp44 = emp321.getJSONObject(x);
//                                            Integer idEmp12 = emp44.getInt("ID");
//                                            String nameEmp12 = emp44.getString("Name");
//                                            String title12 = emp44.getString("Title");
////                                            String phone12 = emp44.getString("Phone");
//                                            if (emp44.has("Email")) {
//                                                String email12 = emp44.getString("Email");
//                                                Log.d(LOG_TAG, "            Сотрудник " + x + ": " + idEmp12 + " " + nameEmp12 + " " + title12 + " " + email12);
//                                            } else {
//                                                Log.d(LOG_TAG, "            Сотрудник " + x + ": " + idEmp12 + " " + nameEmp12 + " " + title12);
//                                            }
//                                        }
//                                    }//сотрудники в Подотделах
//
//                                }
//                            }//отделы в отделах
//                        }
//                    }//отделы
//                } //all

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;

        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            Log.d(LOG_TAG, strJson);

            try {
                JSONObject jsonAll;
                jsonAll = new JSONObject(strJson);

                JSONArray depAll = jsonAll.getJSONArray("Departments");

                for (int i = 0; i < depAll.length(); i++) { //all
                    JSONObject dep0 = depAll.getJSONObject(i);

                    Log.i("GSON", gson.toJson(dep0));

                    //        vseDep = new String[employeeItems.size()];
                    for (int ii = 0; ii < getAllItems.size(); ii++) {
                        GetAll getAll = getAllItems.get(ii);
//            vseDep[i] = employeeItem.getName();
                        Log.d("my_log", "Name:  " + getAll.getName());
                    }

//                    Departments.set(i, depAll.get(i).toString());

//                    JSONArray jsonArray = (JSONArray) jsonObject;
//                    if (jsonArray != null) {
//                        int len = jsonArray.length();
//                        for (int i = 0; i < len; i++) {
//                            list.add(jsonArray.get(i).toString());
//                        }
//                    }
//                    departments.add(dep0.getString("Name"));

//                    getAllItems.add(new GetAll(dep0.getString("ID"), dep0.getString("Name")));


//                    getAllItems.add(new GetAll(dep0.getInt("ID"), dep0.getString("Name")));
//                    Log.d(LOG_TAG, String.valueOf(depAll));

//                    if (dep0.has("Employees")) {//первые сотрудники
//                        JSONArray empAll = dep0.getJSONArray("Employees");
//                        for (int n = 0; n < empAll.length(); n++) {
//                            JSONObject emp0 = empAll.getJSONObject(n);
//                            employeeItems.add(new Employees(emp0.getInt("ID"), emp0.getString("Name"), emp0.getString("Title"), emp0.getString("Email"), emp0.getLong("Phone")));
//                        }
//                    } //первые сотрудники

//                    if (dep0.has("Departments")) {//отделы
//                        JSONArray dep1 = dep0.getJSONArray("Departments");
//                        for (int m = 0; m < dep1.length(); m++) {
//                            JSONObject dep2 = dep1.getJSONObject(m);
//
//                            if (dep2.has("Employees")) {//сотрудники в отделах
//                                JSONArray emp3 = dep2.getJSONArray("Employees");
//                                for (int x = 0; x < emp3.length(); x++) {
//                                    JSONObject emp4 = emp3.getJSONObject(x);
//                                }
//                            }//сотрудники в отделах
//                            if (dep2.has("Departments")) {//отделы в отделах
//                                JSONArray dep123 = dep2.getJSONArray("Departments");
//                                for (int y = 0; y < dep123.length(); y++) {
//                                    JSONObject dep321 = dep123.getJSONObject(y);
//
//                                    if (dep321.has("Employees")) {//сотрудники в Подотделах
//                                        JSONArray emp321 = dep321.getJSONArray("Employees");
//                                        for (int x = 0; x < emp321.length(); x++) {
//                                            JSONObject emp44 = emp321.getJSONObject(x);
//                                        }
//                                    }//сотрудники в Подотделах
//                                }
//                            }//отделы в отделах
//                        }
//                    }//отделы
                } //all

//                Log.d("my_log", employeeItems);

////        vseDep = new String[employeeItems.size()];
//                for (int i = 0; i < employeeItems.size(); i++) {
//                    Employees employeeItem = employeeItems.get(i);
////            vseDep[i] = employeeItem.getName();
//                    Log.d("my_log", "Name:  " + employeeItem.getName());
//                    Log.d("my_log", "Title:  " + employeeItem.getTitle());
//                }

//                        vseDep = new String[employeeItems.size()];
                for (int i = 0; i < getAllItems.size(); i++) {
                    GetAll getAll = getAllItems.get(i);
//            vseDep[i] = employeeItem.getName();
                    Log.d("my_log", "Вывод отделов :  " + getAll.getName());
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
