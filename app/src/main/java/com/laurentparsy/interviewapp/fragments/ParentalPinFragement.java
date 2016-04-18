package com.laurentparsy.interviewapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.laurentparsy.interviewapp.R;

/**
 * Created by Laurent on 18/04/2016.
 */
public class ParentalPinFragement extends DialogFragmentBase implements View.OnClickListener, TextView.OnEditorActionListener{

    private EditText m_ui_etPin;
    private TextView m_ui_tvPinLink;
    private OneSelectionFragment m_dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_pin, container, false);
        m_ui_mainView.addView(rootView);
        m_dialog = OneSelectionFragment.newInstance(true);

        //set the view height and width again after adding it to the main view
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rootView.setLayoutParams(layoutParams);

        setTitle(getString(R.string.pin_parental_title));
        m_ui_etPin = (EditText)rootView.findViewById(R.id.et_pin);
        m_ui_etPin.setOnEditorActionListener(this);
        m_ui_tvPinLink = (TextView)rootView.findViewById(R.id.tv_pin_link);
        m_ui_tvPinLink.setOnClickListener(this);

        return m_ui_mainView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_pin_link){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_pin_link)));
            startActivity(browserIntent);
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE) {
            String text = v.getText().toString();
            if (text.equals(getString(R.string.code))){
                m_dialog.setMessage(getString(R.string.right_code_msg));
                m_dialog.setMsgTitle(getString(R.string.right_code_title));
            }
            else {
                m_dialog.setMessage(getString(R.string.wrong_code_msg));
                m_dialog.setMsgTitle(getString(R.string.wrong_code_title));
            }
            m_dialog.show(getFragmentManager(), "ParentalPin");
        }

        return false;
    }
}
