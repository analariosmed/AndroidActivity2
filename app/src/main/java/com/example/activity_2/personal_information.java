package com.example.activity_2;


import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class personal_information extends AppCompatActivity {

    Button buttonSubmit;
    Button buttonReset;
    EditText nameEditText;
    EditText ageEditText;
    EditText emailEditText;
    EditText phoneEditText;
    EditText addressEditText;
    TextView myTextView;
    CheckBox sports;
    CheckBox music;
    CheckBox movies;
    CheckBox gaming;
    RadioGroup gender;
    RadioButton male;
    RadioButton female;
    RadioButton other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_information);

        nameEditText = findViewById(R.id.name);
        ageEditText = findViewById(R.id.age);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.phone);
        addressEditText = findViewById(R.id.address);
        buttonSubmit = findViewById(R.id.btnSubmit);
        buttonReset = findViewById(R.id.btnReset);
        myTextView = findViewById(R.id.myTextView);
        sports = findViewById(R.id.sports);
        music = findViewById(R.id.music);
        movies = findViewById(R.id.movies);
        gaming = findViewById(R.id.gaming);
        gender = findViewById(R.id.gender);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);



        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
                showInfo();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }


    private void validateFields() {
        ;
        validateMethod("age" , ageEditText);
        validateMethod("email" , emailEditText);
        validateMethod("phone" , phoneEditText);
        validateMethod("address" , addressEditText);
    }

    private String validateMethod(String info, EditText editText) {
        String result = editText.getText().toString();
        if (TextUtils.isEmpty(result)) {
            Toast.makeText(personal_information.this, info + "is required", Toast.LENGTH_SHORT).show();
            return "";
        }
        return result;
    }


    private void showInfo() {
        String name = validateMethod("name", nameEditText);
        String age = ageEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String address = addressEditText.getText().toString();

        boolean isSports = sports.isChecked();
        String sportsStatus = isSports ? "Sports" : null;
        boolean isMovies = movies.isChecked();
        String moviesStatus = isMovies ? "Movies" : null;
        boolean isMusic = music.isChecked();
        String musicStatus = isMusic ? "Music" : null;
        boolean isGaming = gaming.isChecked();
        String gamingStatus = isGaming ? "Gaming" : null;

        StringBuilder interests = new StringBuilder();
        if (sportsStatus != null) interests.append(sportsStatus).append(", ");
        if (moviesStatus != null) interests.append(moviesStatus).append(", ");
        if (musicStatus != null) interests.append(musicStatus).append(", ");
        if (gamingStatus != null) interests.append(gamingStatus);

        int selectedId = gender.getCheckedRadioButtonId();
        String selectedGender = "";
        if (selectedId == R.id.male) {
            selectedGender = "Male";
        } else if (selectedId == R.id.female) {
            selectedGender = "Female";
        } else if (selectedId == R.id.other) {
            selectedGender = "Other";
        }


        //random text in myTextView
        myTextView.setText("Name: " + name + "\n" + "Age: " + age + "\n"
                + "Email: " + email + "\n" + "Phone: " + phone + "\n" + "Address: " +
                address + "\n" + "Interest: " + interests + "\n" + "Gender: " + selectedGender);
    }

    private void resetFields() {
        nameEditText.setText("");
        ageEditText.setText("");
        emailEditText.setText("");
        phoneEditText.setText("");
        addressEditText.setText("");
        gender.clearCheck();
        sports.setChecked(false);
        music.setChecked(false);
        movies.setChecked(false);
        gaming.setChecked(false);
    }
}




