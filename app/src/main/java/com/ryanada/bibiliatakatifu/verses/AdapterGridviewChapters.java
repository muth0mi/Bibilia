package com.ryanada.bibiliatakatifu.verses;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ryanada.bibiliatakatifu.R;
import com.ryanada.bibiliatakatifu.databinding.ActivityMain2Binding;
import com.ryanada.bibiliatakatifu.db.SQliteTransactions;
import com.ryanada.bibiliatakatifu.objects.Chapter;
import com.ryanada.bibiliatakatifu.objects.Verse;

import java.util.ArrayList;

public class ChaptersAdapter extends BaseAdapter {

    private final Main2Activity activity;
    private final ArrayList<Chapter> chapters;
    private final ActivityMain2Binding binding;
    private final Adapter verseAdapter;

    // 1
    public ChaptersAdapter(Main2Activity activity, ArrayList<Chapter> chapters, ActivityMain2Binding binding, Adapter verseAdapter) {
        this.activity = activity;
        this.chapters = chapters;
        this.binding = binding;
        this.verseAdapter = verseAdapter;
    }

    // 2
    @Override
    public int getCount() {
        return chapters.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(activity);
            convertView = layoutInflater.inflate(R.layout.row_chapter, null);

            final TextView chapterNumber = convertView.findViewById(R.id.tvChapterNumber);

            final ViewHolder viewHolder = new ViewHolder(chapterNumber);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.tvChapterNumber.setText(chapters.get(position).getChapter());

        // Highlight current chapter
        if (position == Integer.valueOf(binding.tvChapter.getText().toString()) - 1)
            viewHolder.tvChapterNumber.setBackground(activity.getResources().getDrawable(R.drawable.background_chapter_number_current));


        // Handler for chapter number click
        viewHolder.tvChapterNumber.setOnClickListener(view -> {
                    //Show verses in selected chapter
                    ArrayList<Verse> verses = new SQliteTransactions(activity).getVerses(chapters.get(position));
                    verseAdapter.setVerses(verses);

                    // Set label and close panel
                    binding.tvChapter.setText(((TextView) view).getText());
                    binding.gridview.setVisibility(View.GONE);
                }
        );

        return convertView;
    }


    private class ViewHolder {
        private final TextView tvChapterNumber;

        public ViewHolder(TextView tvChapterNumber) {
            this.tvChapterNumber = tvChapterNumber;
        }
    }

}