package com.activity.AndroidClass2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticlesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticlesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_WEBSITE = "website";

    // TODO: Rename and change types of parameters
    private String website;

    public ArticlesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param website WEbsiteUrl
     * @return A new instance of fragment ArticlesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticlesFragment newInstance(String website) {
        ArticlesFragment fragment = new ArticlesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WEBSITE, website);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            website = getArguments().getString(ARG_WEBSITE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_articles, container, false);
        ((ActivityCNN) getActivity()).fr = this;
        WebView web = (WebView) view.findViewById(R.id.viewWebFrame);
        web.loadUrl("https://" + website);
        TextView text = (TextView) view.findViewById(R.id.viewTitle);
        text.setText(website);
        Button btn = (Button) view.findViewById(R.id.viewPopBtn);
        btn.setOnClickListener(view1 -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));
            startActivity(browserIntent);
        });
        return view;
    }
}