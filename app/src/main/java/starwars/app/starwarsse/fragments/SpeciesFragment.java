package starwars.app.starwarsse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import starwars.app.starwarsse.R;

/**
 * Created by cba on 2017-09-12.
 */

public class SpeciesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ships, container, false);

        return rootView;
    }
}
