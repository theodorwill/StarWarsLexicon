package starwars.app.starwarsse.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import starwars.app.starwarsse.R;
import starwars.app.starwarsse.model.Result;

/**
 * Created by cba on 2017-08-28.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.SearchViewHolder> {

    private List<Result> results;
    private int rowLayout;

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        LinearLayout searchLayout;
        TextView name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender;

        public SearchViewHolder(View searchView) {
            super(searchView);
            searchLayout = (LinearLayout)searchView.findViewById(R.id.searchLayout);
            name = (TextView)searchView.findViewById(R.id.name);
            height = (TextView)searchView.findViewById(R.id.height);
            mass = (TextView)searchView.findViewById(R.id.mass);
            hairColor = (TextView)searchView.findViewById(R.id.hairColor);
            skinColor = (TextView)searchView.findViewById(R.id.skinColor);
            eyeColor = (TextView)searchView.findViewById(R.id.eyeColor);
            birthYear = (TextView)searchView.findViewById(R.id.birthYear);
            gender = (TextView)searchView.findViewById(R.id.gender);
        }
    }

    public PeopleAdapter(List<Result> results, int rowLayout) {
        this.results = results;
        this.rowLayout = rowLayout;

    }

    @Override
    public PeopleAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, final int position) {
        holder.name.setText(results.get(position).getName());
        holder.height.setText("Height: "+results.get(position).getHeight());
        holder.mass.setText("Mass: "+results.get(position).getMass());
        holder.hairColor.setText("Hair color: "+results.get(position).getHairColor());
        holder.skinColor.setText("Skin color: "+results.get(position).getSkinColor());
        holder.eyeColor.setText("Eye color: "+results.get(position).getEyeColor());
        holder.birthYear.setText("Birth year: "+results.get(position).getBirthYear());
        holder.gender.setText("Gender: "+results.get(position).getGender());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
