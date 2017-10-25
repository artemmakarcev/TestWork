package com.example.makarcev_av.testwork;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by makarcev_av on 25.10.2017.
 */

public class InfoEmployeeFragmentImage extends Fragment{

    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.activity_info_employee_image, container, false);

        mWebView = (WebView) rootView.findViewById(R.id.webView);
        mWebView.loadUrl("https://contact.taxsee.com/Contacts.svc/GetWPhoto?login=test_user&password=test_pass&id=1");

        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);

        return rootView;
    }
}
