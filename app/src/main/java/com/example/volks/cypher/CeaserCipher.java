package com.example.volks.cypher;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CeaserCipher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceaser_cipher);
    }

    public void EncodeText(View view) {
        int shift;
        String input;
        String output = "";

        EditText shift_text = (EditText) findViewById(R.id.shift_input);
        EditText ceaser_text = (EditText) findViewById(R.id.ceaser_input);
        TextView textOutput = (TextView) findViewById(R.id.output);

        shift = Integer.parseInt(shift_text.getText().toString());
        input = ceaser_text.getText().toString();

        if (shift >= 1) {

            for (int i = 0; i < input.length(); i++) {
                char tempChar = (input.charAt(i));
                if (tempChar >= 'A' && tempChar <= 'Z') {
                    output += (char) ((tempChar - 'A' + shift) % 26 + 'A');
                } else {
                    if (tempChar >= 'a' && tempChar <= 'z') {
                        output += (char) ((tempChar - 'a' + shift) % 26 + 'a');
                    } else {
                        output += tempChar;
                    }
                }
            }
        } else {
            Context context = getApplicationContext();
            String noShift = getString(R.string.noShift);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, noShift, duration);
            toast.show();
        }
        textOutput.setText(output);
    }

    public void ceaserClear(View view) {
        EditText input = (EditText) findViewById(R.id.ceaser_input);
        EditText shift = (EditText) findViewById(R.id.shift_input);
        TextView output = (TextView) findViewById(R.id.output);

        input.setText("");
        output.setText("");
        shift.setText("0");
    }

    public void ceaserCopy(View view) {
        TextView output = (TextView) findViewById(R.id.output);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("cipher", output.getText().toString());
        clipboard.setPrimaryClip(clip);
    }

    public void decodeText(View view)
    {
        int shift;
        String input;
        String output = "";

        EditText shift_text = (EditText) findViewById(R.id.shift_input);
        EditText ceaser_text = (EditText) findViewById(R.id.ceaser_input);
        TextView textOutput = (TextView) findViewById(R.id.output);

        shift = Integer.parseInt(shift_text.getText().toString());
        input = ceaser_text.getText().toString();

        if (shift >= 1)
        {

                for(int i = 0; i < input.length(); i++)
                {
                    int c = input.charAt(i);
                    if(Character.isUpperCase(c))
                    {
                        c = c -(shift%26);
                        if(c < 'A')
                        {
                            c = c + 26;
                        }
                    }
                    else if(Character.isLowerCase(c))
                    {
                        c = c - (shift%26);
                        if(c <'a')
                        {
                            c = c + 26;
                        }
                    }
                    output = output + (char)c;
                }
        }
        else
        {
            Context context = getApplicationContext();
            String noShift = getString(R.string.noShift);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, noShift, duration);
            toast.show();
        }
        textOutput.setText(output);
    }
}
