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

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder> {

    private List<Result> results;
    private int rowLayout;

    public class VehiclesViewHolder extends RecyclerView.ViewHolder{
        LinearLayout vLayout;
        TextView vName, model, manufacturer, creditCost, length, maxAtmSpeed, crew, passengers,
                cargoCap, consumables, vehicleClass;

        public VehiclesViewHolder(View shipsView){
            super(shipsView);
            vLayout = (LinearLayout)shipsView.findViewById(R.id.vehiclesLayout);
            vName = (TextView)shipsView.findViewById(R.id.vehicleName);
            model = (TextView)shipsView.findViewById(R.id.vModel);
            manufacturer = (TextView)shipsView.findViewById(R.id.vManufacturer);
            creditCost = (TextView)shipsView.findViewById(R.id.vCreditCost);
            length = (TextView)shipsView.findViewById(R.id.vLength);
            maxAtmSpeed = (TextView)shipsView.findViewById(R.id.vMaxSpeed);
            crew = (TextView)shipsView.findViewById(R.id.vCrew);
            passengers = (TextView)shipsView.findViewById(R.id.vPassengers);
            cargoCap = (TextView)shipsView.findViewById(R.id.vCargoCapacity);
            consumables = (TextView)shipsView.findViewById(R.id.vConsumables);
            vehicleClass = (TextView)shipsView.findViewById(R.id.vClass);
        }
    }

    public VehiclesAdapter(List<Result> results, int rowLayout){
        this.results = results;
        this.rowLayout = rowLayout;
    }

    @Override
    public VehiclesAdapter.VehiclesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VehiclesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VehiclesAdapter.VehiclesViewHolder holder, int position) {
        holder.vName.setText(results.get(position).getName());
        holder.model.setText("Model: "+results.get(position).getModel());
        holder.manufacturer.setText("Manufacturer: "+results.get(position).getManufacturer());
        holder.creditCost.setText("Cost in Credits: "+results.get(position).getCostInCredits());
        holder.length.setText("Length: "+results.get(position).getLength());
        holder.maxAtmSpeed.setText("Max Atmosphering Speed: "+results.get(position).getMaxAtmospheringSpeed());
        holder.crew.setText("Crew: "+results.get(position).getCrew());
        holder.passengers.setText("Passengers: "+results.get(position).getPassengers());
        holder.cargoCap.setText("Cargo Capacity: "+results.get(position).getCargoCapacity());
        holder.consumables.setText("Consumables: "+results.get(position).getConsumables());
        holder.vehicleClass.setText("Vehicle class: "+results.get(position).getVehicleClass());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}