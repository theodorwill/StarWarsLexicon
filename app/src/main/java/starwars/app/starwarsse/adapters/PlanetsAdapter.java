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
 * Created by cba on 2017-09-04.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetsViewHolder> {

    private List<Result> results;
    private int rowLayout;

    public class PlanetsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout planetsLayout;
        TextView planetName, rotPeriod, orbPeriod, diameter, climate,
                gravity, terrain, surfWater, population;

        public PlanetsViewHolder(View planetsView) {
            super(planetsView);
            planetsLayout = (LinearLayout) planetsView.findViewById(R.id.planetsLayout);
            planetName = (TextView) planetsView.findViewById(R.id.planetName);
            rotPeriod = (TextView) planetsView.findViewById(R.id.rotPeriod);
            orbPeriod = (TextView) planetsView.findViewById(R.id.orbPeriod);
            diameter = (TextView) planetsView.findViewById(R.id.diameter);
            climate = (TextView) planetsView.findViewById(R.id.climate);
            gravity = (TextView) planetsView.findViewById(R.id.gravity);
            terrain = (TextView) planetsView.findViewById(R.id.terrain);
            surfWater = (TextView) planetsView.findViewById(R.id.surfaceWater);
            population = (TextView) planetsView.findViewById(R.id.population);
        }
    }

    public PlanetsAdapter(List<Result> results, int rowLayout) {
        this.results = results;
        this.rowLayout = rowLayout;
    }

    @Override
    public PlanetsAdapter.PlanetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlanetsAdapter.PlanetsViewHolder holder, int position) {
        holder.planetName.setText(results.get(position).getName());
        holder.rotPeriod.setText("Rotation period: " + results.get(position).getRotationPeriod());
        holder.orbPeriod.setText("Orbital period: " + results.get(position).getOrbitalPeriod());
        holder.diameter.setText("Diameter: " + results.get(position).getDiameter());
        holder.climate.setText("Climate: " + results.get(position).getClimate());
        holder.gravity.setText("Gravity: " + results.get(position).getGravity());
        holder.terrain.setText("Terrain: " + results.get(position).getTerrain());
        holder.surfWater.setText("Surface water: " + results.get(position).getSurfaceWater());
        holder.population.setText("Population: " + results.get(position).getPopulation());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
