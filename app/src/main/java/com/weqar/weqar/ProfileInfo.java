package com.weqar.weqar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;


public class ProfileInfo extends AppCompatActivity {
EditText ET_fname,ET_mname,ET_lname,ET_mobile,ET_address,ET_city,ET_zipcode;
SearchableSpinner SP_mobilepin,SP_country;
ScrollView scrollView_personal,scrollView_professional,scrollView_complete;
Button B_saveandcontinue_personal,B_professional_next;
ImageView IV_personal,IV_professional,IV_complete;
View view1,view2,view3,view4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ET_fname=findViewById(R.id.et_fname);
        ET_mname=findViewById(R.id.et_mname);
        ET_lname=findViewById(R.id.et_lname);
        ET_mobile=findViewById(R.id.et_mobile);
        ET_address=findViewById(R.id.et_address);
        ET_city=findViewById(R.id.et_city);
        ET_zipcode=findViewById(R.id.et_zipcode);
        SP_mobilepin=findViewById(R.id.basic_spiner_countrycode);
        SP_country=findViewById(R.id.basic_spiner_country);
        scrollView_personal=findViewById(R.id.srcollview_personal);
        scrollView_professional=findViewById(R.id.srcollview_professional);
        scrollView_complete=findViewById(R.id.srcollview_complete);
        B_saveandcontinue_personal=findViewById(R.id.saveandcontinue_personal);
        B_professional_next=findViewById(R.id.professional_but_next);
        IV_personal=findViewById(R.id.IV_personaL);
        IV_professional=findViewById(R.id.IV_professional);
        IV_complete=findViewById(R.id.IV_complete);
        view1=findViewById(R.id.profile_view1);
        view2=findViewById(R.id.profile_view2);
        view3=findViewById(R.id.profile_view3);
        view4=findViewById(R.id.profile_view4);

        ET_fname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                   // et_mail.setBackgroundResource( R.drawable.sel_bg_edit);
                    ET_fname.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_fname.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });
        ET_mname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_mname.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_mname.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });
        ET_lname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_lname.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_lname.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });
        ET_mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_mobile.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_mobile.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });
        ET_address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_address.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_address.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });
        ET_city.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_city.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_city.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });
        ET_zipcode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ET_zipcode.setTextColor((getResources().getColor(R.color.colorPrimary)));
                }
                else
                {
                    ET_zipcode.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
            }
        });


        SP_mobilepin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

             //  pin_selec = parent.getItemAtPosition(position).toString();

            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        ET_address.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
//                            .setCountry("KW")
//                            .build();
//
//                    Intent intent =
//                            new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN).setFilter(typeFilter)
//
//                                    .build(Profile_Edit_Personal.this);
//
//                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
//                } catch (GooglePlayServicesRepairableException e) {
//                    //Testing
//                } catch (GooglePlayServicesNotAvailableException e) {
//                    //Testing
//                }
//            }
//        });
        B_saveandcontinue_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView_personal.setVisibility(View.INVISIBLE);
                scrollView_professional.setVisibility(View.VISIBLE);
                scrollView_complete.setVisibility(View.INVISIBLE);
                view2.setBackgroundResource(R.color.colorAccent);
                IV_personal.setImageResource(R.drawable.profile_basic_three);
                IV_professional.setImageResource(R.drawable.profile_professional_two);
                IV_complete.setImageResource(R.drawable.profile_complete_one);

            }
        });
        B_professional_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView_personal.setVisibility(View.INVISIBLE);
                scrollView_professional.setVisibility(View.INVISIBLE);
                scrollView_complete.setVisibility(View.VISIBLE);
                view3.setBackgroundResource(R.color.colorAccent);
                IV_personal.setImageResource(R.drawable.profile_basic_three);
                IV_professional.setImageResource(R.drawable.profile_professional_three);
                IV_complete.setImageResource(R.drawable.profile_complete_two);


            }
        });
    }

}
