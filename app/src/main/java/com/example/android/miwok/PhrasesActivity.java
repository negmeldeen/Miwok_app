package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going ?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("what's your name ?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("my name is ..", "oyaaset",R.raw.phrase_my_name_is));
        words.add(new Word("how are you felling? ", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("i am feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("are you coming ?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("yes, i am coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("i am coming ", "әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("lets go", "yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("come here ", "әnni'nem",R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word=words.get(i);
                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this,word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}