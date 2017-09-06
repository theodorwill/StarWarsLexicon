package starwars.app.starwarsse.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import starwars.app.starwarsse.model.Example;

/**
 * Created by cba on 2017-08-28.
 */

public interface ApiInterface {
    @GET
    Call<Example> getSearchResult(@Url String url);

}
