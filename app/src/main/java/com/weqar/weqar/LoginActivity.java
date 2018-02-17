package com.weqar.weqar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import at.markushi.ui.CircleButton;
import cn.refactor.lib.colordialog.PromptDialog;

public class LoginActivity extends AppCompatActivity {
    EditText ET_username,ET_password;
    Button But_newaxccount;
    CircleButton But_login;
    String sweetmessage,S_username,S_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
        ET_username=findViewById(R.id.login_username);
        ET_password=findViewById(R.id.login_password);
        But_newaxccount=findViewById(R.id.but_newaccount);
        But_login=findViewById(R.id.login_but);
        ET_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_username.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ET_username.setBackgroundResource( R.drawable.edittext_unselected);

                }
            }
        });
        ET_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_password.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ET_password.setBackgroundResource( R.drawable.edittext_unselected);

                }
            }
        });
        But_newaxccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
        But_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnectedToNetwork()) {
                    if(ET_username.getText().toString().equals(""))
                    {
                        sweetmessage="Please Enter Username";
                    }
                    else
                    {
                        if(ET_password.getText().toString().equals(""))
                        {
                            sweetmessage="Please Enter Password";
                        }
                        else
                        {
                            sweetmessage="Thank You! Weqar Welcome You";
                            startActivity(new Intent(LoginActivity.this,ProfileInfo.class));

                        }
                    }


                }
                else
                {
                    sweetmessage="Please Check Your Network Connection";
                }
                new PromptDialog(LoginActivity.this)
                        .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                        .setAnimationEnable(true)
                        .setTitleText(sweetmessage)
                        .setPositiveListener(("ok"), new PromptDialog.OnPositiveListener() {
                            @Override
                            public void onClick(PromptDialog dialog) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
    }
    private boolean isConnectedToNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}
