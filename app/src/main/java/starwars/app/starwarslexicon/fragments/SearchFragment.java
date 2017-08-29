package starwars.app.starwarslexicon.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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

    private static final String searchUrl = "/people/?search=";
    private String searchResult = "Luke";
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;






    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.searchRecyclerView);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        fetchSearchResults();

        return rootView;

    }

    public void fetchSearchResults(){

        mRecyclerView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<Example> call = apiInterface.getSearchResult("people/1/");
        call.enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()){
                    int responseCode = response.code();
                    List<Result> results = response.body().getResults();
                    mRecyclerView.setAdapter(new SearchListAdapter(results,R.layout.fragment_search_item, getActivity()));




                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });



    }




}
