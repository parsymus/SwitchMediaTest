package com.laurentparsy.interviewapp.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.laurentparsy.interviewapp.R;

import org.w3c.dom.Text;

/**
 * Created by Laurent on 18/04/2016.
 */
public class OneSelectionFragment extends DialogFragmentBase implements View.OnClickListener {

    private String m_msg, m_title = null;
    private boolean m_dialog = false;

    /**
     * true for a small dialog and false for a fullscreen dialog.
     * @param type
     * @return
     */
    static public OneSelectionFragment newInstance(boolean type) {

        OneSelectionFragment frag = new OneSelectionFragment();
        Bundle args = new Bundle();
        args.putBoolean("dialog", type);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_dialog = getArguments().getBoolean("dialog");
        if (m_dialog)
            setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Dialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_one_selection, container, false);
        //add onSelectionFragment content to the dialogBaseFragment
        m_ui_mainView.addView(rootView);

        //remove the topBar for small dialog
        if (m_dialog)
            showTopBar(false);

        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rootView.setLayoutParams(layoutParams);
        TextView tvMsg = (TextView)rootView.findViewById(R.id.tv_one_selec_msg);
        if (m_msg != null)
            tvMsg.setText(m_msg);
        TextView tvTitle = (TextView)rootView.findViewById(R.id.tv_one_selec_title);
        if (m_title != null)
            tvTitle.setText(m_title);
        Button buttonConfirm = (Button)rootView.findViewById(R.id.btn_one_selec_confirm);
        buttonConfirm.setOnClickListener(this);
        return m_ui_mainView;
    }

    public void setMessage(final String msg){
        m_msg = msg;
    }

    public void setMsgTitle(final String title){
        m_title = title;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_one_selec_confirm)
            dismiss();
    }
}
