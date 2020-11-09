package edu.cs.birzeit.yasss;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.prefs.PreferenceChangeListener;

public class MainActivity<bmiValue> extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String HEIGHT = "HEIGHT";
    public static final String WEIGHT = "WEIGHT";
    public static final String GENDER = "GENDER";
    public static final String FLAG = "FLAG";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private EditText txtName;
    private EditText txtHeight;
    private EditText txtWeight;
    //   private CheckBox ChcBox;
    private EditText txtBodyMassIndex;
    private Button btnSave;
    private Button btnStopWatch;
    public Spinner SpinnerGender;
    // private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   setupViews();
        setupSharedPrefs();
        checkPrefs();*/

        txtName = findViewById(R.id.txtName);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        txtBodyMassIndex = findViewById(R.id.txtBodyMassIndex);
        btnSave = findViewById(R.id.btnSave);
        btnStopWatch = findViewById(R.id.btnStopWatch);
        SpinnerGender = findViewById(R.id.SpinnerGender);
        // ChcBox.findViewById(R.id.ChcBox);
        addToSpinner();
    }

    private void addToSpinner() {
        String[] arraySpinner = new String[]{
                "Female",    "Male"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerGender.setAdapter(adapter);
    }


    public void btnSaveOnClick(View view) {

    /*    String name = txtName.getText().toString();
        String height = txtHeight.getText().toString();
        String weight = txtWeight.getText().toString();
       String gender = SpinnerGender.getSelectedItem().toString();

       if (ChcBox.isChecked()) {
            editor.putString(NAME, name);
            editor.putString(HEIGHT, height);
            editor.putString(WEIGHT, weight);
           editor.putString(GENDER, gender);
            editor.putBoolean(FLAG, true);
            editor.commit();


        }*/


        String msg = txtName.getText().toString();
        String msg1 = txtHeight.getText().toString();
        String msg2 = txtWeight.getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("data", msg);
        startActivity(intent);
    }


    public void btnStopWatchOnClick(View view) {
        String msgStopWatch = btnStopWatch.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("data", msgStopWatch);
        startActivity(intent);
    }

    private void setupViews() {
        txtName.findViewById(R.id.txtName);
        txtHeight.findViewById(R.id.txtHeight);
        txtWeight.findViewById(R.id.txtWeight);
        SpinnerGender.findViewById(R.id.SpinnerGender);
        //  ChcBox.findViewById(R.id.ChcBox);

    }

    private void checkPrefs() {
        boolean flag = prefs.getBoolean(FLAG, false);

        if (flag) {
            String name = prefs.getString(NAME, "");
            String height = prefs.getString(HEIGHT, "");
            String weight = prefs.getString(WEIGHT, "");
            String gender = prefs.getString(GENDER, "");
            txtName.setText(name);
            txtHeight.setText(height);
            txtWeight.setText(weight);


            SpinnerGender.getSelectedItem();
            // ChcBox.setChecked(true);

        }

    }


    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

    }

    public void btnCalcOnClick(View view) {
        String heightS = txtHeight.getText().toString();
        String weightS = txtWeight.getText().toString();


        if (heightS != null && !"".equals(heightS)
                && weightS != null && !"".equals(weightS)) {
            float heightValue = Float.parseFloat(heightS) / 100;
            float weightValue = Float.parseFloat(weightS);

            float bmi = weightValue / (heightValue * heightValue);

            //     displayBMI(bmi);
        }

    }



    private String interpretBMI(float bmiValue) {


        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }




}
