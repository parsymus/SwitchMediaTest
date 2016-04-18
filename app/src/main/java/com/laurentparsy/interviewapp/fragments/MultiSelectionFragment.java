package com.laurentparsy.interviewapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.laurentparsy.interviewapp.R;

/**
 * Created by Laurent on 18/04/2016.
 */
public class MultiSelectionFragment extends DialogFragmentBase implements View.OnClickListener {

    OneSelectionFragment m_dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_multi_selection, container, false);
        m_ui_mainView.addView(rootView);
        m_dialog = OneSelectionFragment.newInstance(true);
        m_dialog.setMsgTitle(getString(R.string.opinion));
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rootView.setLayoutParams(layoutParams);
        Button button1 = (Button)rootView.findViewById(R.id.btn_multi_selec_one);
        Button button2 = (Button)rootView.findViewById(R.id.btn_multi_selec_two);
        Button button3 = (Button)rootView.findViewById(R.id.btn_multi_selec_three);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        setTitle(getString(R.string.multi_selec_title));
        return m_ui_mainView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_multi_selec_one:
                m_dialog.setMessage(getString(R.string.walk_opinion));
                break;
            case R.id.btn_multi_selec_two:
                m_dialog.setMessage(getString(R.string.drive_opinion));
                break;
            case R.id.btn_multi_selec_three:
                m_dialog.setMessage(getString(R.string.teleport_opinion));
                break;
        }
        m_dialog.show(getFragmentManager(), "ParentalPin");
    }
}
