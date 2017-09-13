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
 * Created by cba on 2017-09-13.
 */

public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder> {

    private List<Result> results;
    private int rowLayout;

    public class SpeciesViewHolder extends RecyclerView.ViewHolder{
        LinearLayout speciesLayout;
        TextView speciesName, classification, designation, avgHeight, skinColors, hairColors,
                eyeColors, avgLifeSpan, homeWorld, language;

        public SpeciesViewHolder(View speciesView){
            super(speciesView);
            speciesLayout = (LinearLayout)speciesView.findViewById(R.id.speciesLayout);
            speciesName = (TextView)speciesView.findViewById(R.id.speciesName);
            classification = (TextView)speciesView.findViewById(R.id.classification);
            designation = (TextView)speciesView.findViewById(R.id.designation);
            avgHeight = (TextView)speciesView.findViewById(R.id.avgHeight);
            skinColors = (TextView)speciesView.findViewById(R.id.speciesSkinColors);
            hairColors = (TextView)speciesView.findViewById(R.id.speciesHairColors);
            eyeColors = (TextView)speciesView.findViewById(R.id.speciesEyeColors);
            avgLifeSpan = (TextView)speciesView.findViewById(R.id.avgLifespan);
            homeWorld = (TextView)speciesView.findViewById(R.id.homeWorld);
            language = (TextView)speciesView.findViewById(R.id.language);
        }
    }

    public SpeciesAdapter(List<Result> results, int rowLayout){
        this.results = results;
        this.rowLayout = rowLayout;
    }

    @Override
    public SpeciesAdapter.SpeciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SpeciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpeciesAdapter.SpeciesViewHolder holder, int position) {
        holder.speciesName.setText(results.get(position).getName());
        holder.classification.setText("Classification: "+results.get(position).getClassification());
        holder.designation.setText("Designation: "+results.get(position).getDesignation());
        holder.avgHeight.setText("Average height: "+results.get(position).getAverageHeight());
        holder.skinColors.setText("Skin colors: "+results.get(position).getSkinColors());
        holder.hairColors.setText("Hair colors: "+results.get(position).getHairColors());
        holder.eyeColors.setText("Eye colors: "+results.get(position).getEyeColors());
        holder.avgLifeSpan.setText("Average lifespan: "+results.get(position).getAverageLifespan());
        holder.homeWorld.setText("Home world: "+results.get(position).getHomeworld());
        holder.language.setText("Language: "+results.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
