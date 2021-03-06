package com.example.gmsproduction.dregypt.ui.fragments.Pharmacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gmsproduction.dregypt.Models.LocationModel;
import com.example.gmsproduction.dregypt.R;

import java.util.ArrayList;

/**
 * Created by Ahmed Fahmy on 12/5/2017.
 */

public class AdapterLocationPharmacyRecylcer extends RecyclerView.Adapter<AdapterLocationPharmacyRecylcer.Myholder> {
    private Context context;
    ArrayList<LocationModel> arrayList;
    String TAG = "PharmacyActivity";
    int id;
    Intent intent;

    public AdapterLocationPharmacyRecylcer(Context context, ArrayList<LocationModel> arrayList, int id) {

        this.context = context;
        this.arrayList = arrayList;
        this.id = id;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_recycler_city, parent, false);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(final Myholder holder, final int position) {

        final LocationModel model = arrayList.get(position);

        holder.textView.setText(model.getLocName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = context.getSharedPreferences("LocationP", context.MODE_PRIVATE).edit();

                if (id == 1) {
                    editor.putString("region_name", model.getLocName());
                    editor.putInt("region_id", model.getLocId());
                    editor.apply();

                   /* ((FragmentActivity) view.getContext()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_pha,new CityPharmacyFragment(),"CityPharmacyFragment")
                            .commit();;*/
                }
                else {
                    editor.putString("city_name", model.getLocName());
                    editor.putInt("city_id", model.getLocId());
                    editor.apply();
                    /*((FragmentActivity) view.getContext()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_pha,new PharmacyFragment(),"PharmacyFragment")
                            .commit();;*/

                }

            }
        });

    }
        @Override
    public int getItemCount() {
        return arrayList.size();


    }

    class Myholder extends RecyclerView.ViewHolder {
        TextView textView;


        public Myholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.city_text);


        }
    }
}
