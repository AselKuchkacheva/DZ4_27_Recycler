package com.example.dz4_27_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_CHANGED = "changedText";
    private String textPosition;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText);
        getIntentRec();
    }

    private void getIntentRec() {
        Intent intent = getIntent();
        textPosition = intent.getStringExtra(MainActivity.KEY_RES);
        editText.setText(textPosition);
    }

    public void toMainForPaste(View view) {
        String changedText = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(KEY_CHANGED, changedText);
        setResult(RESULT_OK, intent);
        finish();
    }
}