package starwars.app.starwarsse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import starwars.app.starwarsse.adapters.PlanetsAdapter;
import starwars.app.starwarsse.R;
import starwars.app.starwarsse.api.ApiInterface;
import starwars.app.starwarsse.model.Example;
import starwars.app.starwarsse.model.Result;

/**
 * Created by cba on 2017-08-28.
 */

public class PlanetsFragment extends Fragment {

    private static final String searchUrl = "planets/?search=";
    private String searchResult = "";
    private RecyclerView rv;
    private EditText searchField;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_planets, container, false);

        rv = (RecyclerView)rootView.findViewById(R.id.planetRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        searchField = (EditText)rootView.findViewById(R.id.planetSearchBar);
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchResult = searchField.getText().toString();
                fetchSearchResults();
            }
        });

        return rootView;
    }

    public void fetchSearchResults(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Example> call = apiInterface.getSearchResult(searchUrl+searchResult);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.isSuccessful()) {
                    List<Result> results = response.body().getResults();
                    rv.setAdapter(new PlanetsAdapter(results, R.layout.fragment_planets_item, getContext()));
                }
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getActivity(), "API call failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
