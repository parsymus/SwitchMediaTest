package com.laurentparsy.interviewapp;

import android.app.DialogFragment;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.laurentparsy.interviewapp.fragments.MultiSelectionFragment;
import com.laurentparsy.interviewapp.fragments.OneSelectionFragment;
import com.laurentparsy.interviewapp.fragments.ParentalPinFragement;


public class MainActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    private DialogFragment m_oneSelectionFragment;
    private DialogFragment m_multiSelectionFragment;
    private DialogFragment m_pinFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ui_listView = (ListView)findViewById(R.id.lv_home);
        //add the first and last divider
        ui_listView.addFooterView(new View(this), null, true);
        ui_listView.addHeaderView(new View(this), null, true);

        String[] choicesList = new String[] {
                getString(R.string.item1),
                getString(R.string.item2),
                getString(R.string.item3)
        };
        m_oneSelectionFragment = OneSelectionFragment.newInstance(false);
        m_multiSelectionFragment = new MultiSelectionFragment();
        m_pinFragment = new ParentalPinFragement();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_listview_item, R.id.tv_item_name, choicesList);
        ui_listView.setAdapter(arrayAdapter);
        ui_listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 1:
                m_oneSelectionFragment.show(getFragmentManager(), "HomePage");
                break;
            case 2:
                m_multiSelectionFragment.show(getFragmentManager(), "HomePage");
                break;
            case 3:
                m_pinFragment.show(getFragmentManager(), "HomePage");
                break;
        }

    }
}
