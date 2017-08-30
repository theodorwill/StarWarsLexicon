package starwars.app.starwarslexicon.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import starwars.app.starwarslexicon.R;
import starwars.app.starwarslexicon.model.Result;

/**
 * Created by cba on 2017-08-28.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchViewHolder> {

    private List<Result> results;
    private int rowLayout;
    private Context context;

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        LinearLayout searchLayout;
        TextView name;
        TextView hairColor;
        TextView eyeColor;

        public SearchViewHolder(View searchView) {
            super(searchView);
            searchLayout = (LinearLayout) searchView.findViewById(R.id.searchLayout);
            name = (TextView) searchView.findViewById(R.id.name);
            hairColor = (TextView) searchView.findViewById(R.id.hairColor);
            eyeColor = (TextView) searchView.findViewById(R.id.eyeColor);
        }
    }

    public SearchListAdapter(List<Result> results, int rowLayout, Context context) {
        this.results = results;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SearchListAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, final int position) {
        holder.name.setText("Name: "+results.get(position).getName());
        holder.hairColor.setText("Hair color: "+results.get(position).getHairColor());
        holder.eyeColor.setText("Eye color: "+results.get(position).getEyeColor());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
