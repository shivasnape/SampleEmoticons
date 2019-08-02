package com.shivasnape.shivichu.sampleemoticons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class MainActivity extends AppCompatActivity {

    private EmojiconEditText mEmojiconEditText;
    private EmojiconTextView mTextView;
    private EmojIconActions mEmojIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mRootView = findViewById(R.id.root_view);
        ImageView mEmojiButton = (ImageView) findViewById(R.id.emoji_btn);
        ImageView mSubmitButton = (ImageView) findViewById(R.id.submit_btn);
        CheckBox mCheckBox = (CheckBox) findViewById(R.id.use_system_default);
        mEmojiconEditText = (EmojiconEditText) findViewById(R.id.emojicon_edit_text);
        mTextView = (EmojiconTextView) findViewById(R.id.textView);

        mEmojIcon = new EmojIconActions(this, mRootView, mEmojiconEditText, mEmojiButton);
        mEmojIcon.ShowEmojIcon();

        mEmojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                Log.e("Keyboard", "open");
            }

            @Override
            public void onKeyboardClose() {
                Log.e("Keyboard", "close");
            }
        });

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mEmojIcon.setUseSystemEmoji(b);
                mTextView.setUseSystemDefault(b);
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = mEmojiconEditText.getText().toString();
                mTextView.setText(newText);
            }
        });
    }
}