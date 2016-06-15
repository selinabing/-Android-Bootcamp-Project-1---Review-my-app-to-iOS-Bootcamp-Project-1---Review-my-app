package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText newText;
    int position;
    String originalTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        position = getIntent().getIntExtra("position",-100);
        originalTxt = getIntent().getStringExtra("originalText");
        newText = (EditText) findViewById(R.id.newText);
        newText.setText(originalTxt);
        newText.setSelection(originalTxt.length());
    }

    public void onChangeItem(View view) {
        EditText newText = (EditText) findViewById(R.id.newText);
        Intent data = new Intent();
        data.putExtra("text",newText.getText().toString());
        data.putExtra("pos",position);
        setResult(RESULT_OK, data);
        finish();
    }
}
