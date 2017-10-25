package com.example.makarcev_av.testwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by makarcev_av on 25.10.2017.
 */

public class ListUserEmp extends AppCompatActivity implements ListFragmentFourth.OnSelectedItem {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_emp);

        //Программное добавление фрагмента в контейнер
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // Создаем и добавляем первый фрагмент
        ListFragmentFourth listFragmentFourth = new ListFragmentFourth();
        ft.add(R.id.containerListFragmentEmp, listFragmentFourth, "listFragment4");
        // Подтверждаем операцию

        Intent intent = getIntent();
//
//
//        Bundle bundle = new Bundle();
//        bundle.putInt("itemIndex", intent.getIntExtra("itemIndex", 0));
//        listFragmentSecond.setArguments(bundle);
        ft.commit();

    }

    @Override
    public void onItemSelected(int itemIndex) {
        Intent intent = new Intent(this, InfoEmployee.class);
//        intent.putExtra("itemIndex", itemIndex);
        startActivity(intent);
    }
}
