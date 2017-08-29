package starwars.app.starwarslexicon.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import starwars.app.starwarslexicon.model.Example;
import starwars.app.starwarslexicon.model.Result;

/**
 * Created by cba on 2017-08-28.
 */

public interface ApiInterface {
    @GET
    Call<Example> getSearchResult(@Url String url);
}
