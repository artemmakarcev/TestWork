package com.example.makarcev_av.testwork;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by makarcev_av on 25.10.2017.
 */

public class InfoEmployeeFragmentDescription extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.activity_info_employee_description, container, false);
        return rootView;
    }
}
