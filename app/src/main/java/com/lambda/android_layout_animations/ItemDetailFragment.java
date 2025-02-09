package com.lambda.android_layout_animations;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
// S04M03-11 remove all references to dummy content
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the mItem ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private Pokemon mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
//            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            // S04M03-19 pull the object from the arguments
            mItem = (Pokemon) getArguments().getSerializable(ARG_ITEM_ID);
            Activity                activity     = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            /*appBarLayout.setBackground(getContext().getDrawable(
                    DrawableResolver.getDrawableId(
                            mItem.getCategory(),
                            mItem.getId())));*/
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            // S04M03-20 set content to be our drawable
           // ((ImageView) rootView.findViewById(R.id.item_detail)).setImageDrawable(
                  //  rootView.getContext().getDrawable(
                           // DrawableResolver.getDrawableId(
                              //      mItem.getCategory(),
                              //      mItem.getId())));
        }

        return rootView;
    }
}
