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
 * Created by cba on 2017-09-12.
 */

public class ShipsAdapter extends RecyclerView.Adapter<ShipsAdapter.ShipsViewHolder> {

    private List<Result> results;
    private int rowLayout;

    public class ShipsViewHolder extends RecyclerView.ViewHolder{
        LinearLayout shipsLayout;
        TextView shipName, model, manufacturer, creditCost, length, maxAtmSpeed, crew, passengers,
        cargoCap, consumables, hyperDRating, mGLT, starShipClass;

        public ShipsViewHolder(View shipsView){
            super(shipsView);
            shipsLayout = (LinearLayout)shipsView.findViewById(R.id.shipsLayout);
            shipName = (TextView)shipsView.findViewById(R.id.shipName);
            model = (TextView)shipsView.findViewById(R.id.model);
            manufacturer = (TextView)shipsView.findViewById(R.id.manufacturer);
            creditCost = (TextView)shipsView.findViewById(R.id.creditCost);
            length = (TextView)shipsView.findViewById(R.id.shipLength);
            maxAtmSpeed = (TextView)shipsView.findViewById(R.id.maxSpeed);
            crew = (TextView)shipsView.findViewById(R.id.crew);
            passengers = (TextView)shipsView.findViewById(R.id.passengers);
            cargoCap = (TextView)shipsView.findViewById(R.id.cargoCapacity);
            consumables = (TextView)shipsView.findViewById(R.id.consumables);
            hyperDRating = (TextView)shipsView.findViewById(R.id.hdRating);
            mGLT = (TextView)shipsView.findViewById(R.id.mGLT);
            starShipClass = (TextView)shipsView.findViewById(R.id.shipClass);
        }
    }

    public ShipsAdapter(List<Result> results, int rowLayout){
        this.results = results;
        this.rowLayout = rowLayout;
    }

    @Override
    public ShipsAdapter.ShipsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ShipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShipsAdapter.ShipsViewHolder holder, int position) {
        holder.shipName.setText(results.get(position).getName());
        holder.model.setText("Model: "+results.get(position).getModel());
        holder.manufacturer.setText("Manufacturer: "+results.get(position).getManufacturer());
        holder.creditCost.setText("Cost in Credits: "+results.get(position).getCostInCredits());
        holder.length.setText("Length: "+results.get(position).getLength());
        holder.maxAtmSpeed.setText("Max Atmosphering Speed: "+results.get(position).getMaxAtmospheringSpeed());
        holder.crew.setText("Crew: "+results.get(position).getCrew());
        holder.passengers.setText("Passengers: "+results.get(position).getPassengers());
        holder.cargoCap.setText("Cargo Capacity: "+results.get(position).getCargoCapacity());
        holder.consumables.setText("Consumables: "+results.get(position).getConsumables());
        holder.hyperDRating.setText("Hyperdrive Rating: "+results.get(position).getHyperdriveRating());
        holder.mGLT.setText("MGLT: "+results.get(position).getMGLT());
        holder.starShipClass.setText("Starship Class: "+results.get(position).getStarshipClass());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
