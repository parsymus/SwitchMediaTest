package com.laurentparsy.interviewapp.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.laurentparsy.interviewapp.R;

/**
 * Created by Laurent on 18/04/2016.
 */
public class DialogFragmentBase extends DialogFragment {

    protected LinearLayout m_ui_mainView;
    protected TextView m_ui_tvCancel;
    protected TextView m_ui_tvTitle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,android.R.style.Theme_Holo_Light);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_base, container, false);
        m_ui_mainView = (LinearLayout)rootView;

        m_ui_tvTitle = (TextView)m_ui_mainView.findViewById(R.id.tv_top_bar_title);
        m_ui_tvCancel = (TextView)m_ui_mainView.findViewById(R.id.tv_top_bar_cancel);

        m_ui_tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

    public void showTopBar(boolean show){
        m_ui_mainView.findViewById(R.id.ll_top_bar).setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setTitle(final String title){
        m_ui_tvTitle.setText(title);
    }
}
