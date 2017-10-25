package com.example.makarcev_av.testwork;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListFragmentThird extends ListFragment {

    String[] vseDep = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);

        int n = 15;
        String[] vseDep = new String[n];
        for (int i = 0; i < n; i++) {
            vseDep[i] = String.valueOf(i);
        }
        ListAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, vseDep);
        setListAdapter(adapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        OnSelectedItem itemListener = (OnSelectedItem) getActivity();
        itemListener.onItemSelected(position);

    }

    public interface OnSelectedItem {
        void onItemSelected(int itemIndex);
    }

}

