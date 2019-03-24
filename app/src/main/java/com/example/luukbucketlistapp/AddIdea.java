package com.example.luukbucketlistapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddIdea extends AppCompatActivity {
    private Button createBtn;
    private EditText nameBox;
    private EditText descriptionBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_idea);

        createBtn = findViewById(R.id.createButton);
        nameBox = findViewById(R.id.nameBox);
        descriptionBox = findViewById(R.id.descriptionBox);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameBox.getText().toString();
                String description = descriptionBox.getText().toString();

                if(!(name.isEmpty() || description.isEmpty())){
                    Intent intentResult = new Intent();
                    intentResult.putExtra(MainActivity.EXTRATEXT_NAME, name);
                    intentResult.putExtra(MainActivity.EXTRATEXT_DESCRIPTION, description);
                    setResult(Activity.RESULT_OK, intentResult);
                    finish();
                }else{
                    Snackbar.make(v, "Make sure that both fields are filled in", Snackbar.LENGTH_SHORT).show();

                }
            }
        });

    }
}
