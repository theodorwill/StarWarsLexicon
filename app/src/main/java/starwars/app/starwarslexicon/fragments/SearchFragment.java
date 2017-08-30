package starwars.app.starwarslexicon.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import starwars.app.starwarslexicon.Adapters.SearchListAdapter;
import starwars.app.starwarslexicon.R;
import starwars.app.starwarslexicon.api.ApiInterface;
import starwars.app.starwarslexicon.builder.RetrofitBuilder;
import starwars.app.starwarslexicon.model.Example;
import starwars.app.starwarslexicon.model.Result;

/**
 * Created by cba on 2017-08-28.
 */

public class SearchFragment extends Fragment {

    private static final String searchUrl = "people/?search=";
    private String searchResult = "";
    private RecyclerView rv;
    private EditText searchField;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        rv = (RecyclerView)rootView.findViewById(R.id.searchRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        searchField = (EditText)rootView.findViewById(R.id.textSearchBar);

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchResult = searchField.getText().toString();
                fetchSearchResults();

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
                int statusCode = response.code();
                List<Result> results = response.body().getResults();
                rv.setAdapter(new SearchListAdapter(results, R.layout.fragment_search_item, getContext()));

                Log.d("responseCall", "onResponse" + statusCode);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }




}
