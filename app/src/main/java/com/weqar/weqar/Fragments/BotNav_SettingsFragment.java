package com.weqar.weqar.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weqar.weqar.R;


public class BotNav_SettingsFragment extends Fragment {
    public static BotNav_SettingsFragment newInstance() {
        BotNav_SettingsFragment fragment= new BotNav_SettingsFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bot_nav__notifications, container, false);
    }


}
