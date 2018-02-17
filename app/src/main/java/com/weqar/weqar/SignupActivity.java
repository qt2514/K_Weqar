package com.weqar.weqar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.refactor.lib.colordialog.PromptDialog;

public class SignupActivity extends AppCompatActivity {
    EditText ET_username,ET_password,ET_confirmpassword;
    String S_username,S_password,S_confirmpassword,sweetmessage;
    Button B_signup,B_sel_user,B_sel_vendor;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_signup);
        ET_username=findViewById(R.id.signup_username);
        ET_password=findViewById(R.id.signup_password);
        ET_confirmpassword=findViewById(R.id.signup_confirm);
        B_signup=findViewById(R.id.but_signup);
        B_sel_user=findViewById(R.id.Signup_But_user);
        B_sel_vendor=findViewById(R.id.Signup_But_vendor);
        context=this;
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
        ET_confirmpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_confirmpassword.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ET_confirmpassword.setBackgroundResource( R.drawable.edittext_unselected);

                }
            }
        });
        B_sel_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B_sel_user.setBackgroundResource(R.drawable.but_selected);
               B_sel_vendor.setBackgroundResource(R.drawable.but_unselected);
            }
        });
        B_sel_vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B_sel_vendor.setBackgroundResource(R.drawable.but_selected);
                B_sel_user.setBackgroundResource(R.drawable.but_unselected);

            }
        });
        B_signup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
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
                            if(ET_confirmpassword.getText().toString().equals(""))
                            {
                                sweetmessage="Please Enter Confirm Password";
                            }
                            else
                            {
                                    S_username=ET_username.getText().toString();
                                    S_password=ET_password.getText().toString();
                                    S_confirmpassword=ET_confirmpassword.getText().toString();
                                if (!S_password.equals(S_confirmpassword))
                                {
                                    sweetmessage = "Password Mismatch";

                                }
                                else
                                {
                                    startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                                }

                            }
                        }
                    }
                }
                else
                {
                    sweetmessage="Please Check Your Internet";
                }
//                ColorDialog dialog = new ColorDialog(SignupActivity.this);
//                dialog.setTitle(sweetmessage);
////                dialog.setContentText(getString(R.string.content_text));
//                dialog.setContentImage(getResources().getDrawable(R.drawable.ic_back));
//                dialog.setPositiveListener(("OK"), new ColorDialog.OnPositiveListener() {
//                    @Override
//                    public void onClick(ColorDialog dialog) {
                        new PromptDialog(SignupActivity.this)
                                .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                                .setAnimationEnable(true)
                                .setTitleText(sweetmessage)
                                .setPositiveListener(("ok"), new PromptDialog.OnPositiveListener() {
                                    @Override
                                    public void onClick(PromptDialog dialog) {
                                        dialog.dismiss();
                                    }
                                }).show();
//                    }
//                })
//                        .setNegativeListener(("cancel"), new ColorDialog.OnNegativeListener() {
//                            @Override
//                            public void onClick(ColorDialog dialog) {
//                                Toast.makeText(SignupActivity.this, dialog.getNegativeText().toString(), Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();
//                            }
//                        }).show();

            }
        });
    }
    private boolean isConnectedToNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
