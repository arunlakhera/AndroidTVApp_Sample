package com.example.androidtvapp_sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.app.BrowseSupportFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends BrowseSupportFragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        setupUIElements();

        loadRows();
    }

    public void setupUIElements(){
        setTitle("Hello Android TV!");

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        setBrandColor(getResources().getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));

    }

    private void loadRows(){

        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        //GridItemPresenter
        HeaderItem gridItemHeaderPresenter1 = new HeaderItem(0, "GridItemPresenter 1");

        GridItemPresenter mGridPresenter1 = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter1 = new ArrayObjectAdapter(mGridPresenter1);
        gridRowAdapter1.add("Item 1");
        gridRowAdapter1.add("Item 2");
        gridRowAdapter1.add("Item 3");
        gridRowAdapter1.add("Item 4");
        gridRowAdapter1.add("Item 5");

        mRowsAdapter.add(new ListRow(gridItemHeaderPresenter1, gridRowAdapter1));

        //GridItemPresenter
        HeaderItem gridItemHeaderPresenter2 = new HeaderItem(0, "GridItemPresenter 2");

        GridItemPresenter mGridPresenter2 = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter2 = new ArrayObjectAdapter(mGridPresenter2);
        gridRowAdapter2.add("Item 1");
        gridRowAdapter2.add("Item 2");
        gridRowAdapter2.add("Item 3");
        gridRowAdapter2.add("Item 4");
        gridRowAdapter2.add("Item 5");

        mRowsAdapter.add(new ListRow(gridItemHeaderPresenter2, gridRowAdapter2));

        //GridItemPresenter
        HeaderItem gridItemHeaderPresenter3 = new HeaderItem(0, "GridItemPresenter 3");

        GridItemPresenter mGridPresenter3 = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter3 = new ArrayObjectAdapter(mGridPresenter3);
        gridRowAdapter3.add("Item 1");
        gridRowAdapter3.add("Item 2");
        gridRowAdapter3.add("Item 3");
        gridRowAdapter3.add("Item 4");
        gridRowAdapter3.add("Item 5");

        mRowsAdapter.add(new ListRow(gridItemHeaderPresenter3, gridRowAdapter3));

        /* CardPresenter */
        HeaderItem cardPresenterHeader = new HeaderItem(1, "CardPresenter");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for(int i=0; i<10; i++) {
            Movie movie = new Movie();
            movie.setTitle("title" + i);
            movie.setStudio("studio" + i);
            cardRowAdapter.add(movie);
        }
        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));

        // Set adapter
        setAdapter(mRowsAdapter);

    }

    private class GridItemPresenter extends Presenter{

        @Override
        public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {

            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.default_background));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {

            ((TextView) viewHolder.view).setText((String) item);
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }
}
