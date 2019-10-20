package com.example.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_KEY = "myPreferences";
    public static final String NAME_KEY = "name";
    public static final String AGE_KEY = "age";

    EditText nameEdit;
    EditText ageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameEdit = findViewById(R.id.name_edit);
        ageEdit = findViewById(R.id.age_edit);

        // Shared preferences.
        SharedPreferences pref = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        // Editor to be able to make changes to the preferences.
        // SharedPreferences.Editor editor = pref.edit();

        // Write
        // Get a variable.
        // String varToBeSaved = "William";
        // Store the variable together with a key.
        // editor.putString(NAME_KEY, varToBeSaved);
        // editor.putInt(AGE_KEY, 14);
        // Remove
        // editor.remove(NAME_KEY);

        // Apply the changes.
        // editor.apply();
        // editor.commit();

        // Read
        // pref.contains(NAME_KEY) Returns true if a value exists under a given the NAME_KEY


        if (pref.contains(NAME_KEY)) {
            String name = pref.getString(NAME_KEY, null);
            Log.d("willy", name);
            nameEdit.setText(name);
        }

        if (pref.contains(AGE_KEY)) {
            int age = pref.getInt(AGE_KEY, 0);
            String ageToDisplay = "" + age;
            Log.d("willy", ageToDisplay);
            // ageEdit.setText(age);
        }









        // ... Do stuff with vars

    }

    // Change image in code
    public void changeImage() {
        // Find the imageView xml element
        // ImageView imageView = findViewById(R.id.snowflake_image_view);
        // Set a new image resource with an id
        // imageView.setImageResource(R.drawable.download);

        // Find id based on the name of a resource. dog_image in this case
        // int id = getResources().getIdentifier("dog_image", "drawable", getPackageName());
        // imageView.setImageResource(id);

    }

    public void saveBtnClicked(View view) {


        String nameToSave = nameEdit.getText().toString();

        int ageToSave = Integer.parseInt(ageEdit.getText().toString());

        // Shared preferences.
        SharedPreferences pref = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        // Editor to be able to make changes to the preferences.
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(NAME_KEY, nameToSave);
        editor.putInt(AGE_KEY, ageToSave);

        editor.apply();
    }
}
