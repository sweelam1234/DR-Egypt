package com.example.gmsproduction.dregypt.Data.remoteDataSource.NetworkRequests.ProductAdsRequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.gmsproduction.dregypt.Data.remoteDataSource.VolleyLIbUtils;
import com.example.gmsproduction.dregypt.utils.Constants;

/**
 * Created by mohmed mostafa on 23/04/2018.
 */

public class GetUserProducts {

    VolleyLIbUtils volleyLIbUtils;
    String url;
    int method_id;

    public GetUserProducts(Context context, int id, Response.Listener<String> listener, Response.ErrorListener errorListener){
        setValues(id);
        volleyLIbUtils=new VolleyLIbUtils(context,method_id,url,listener,errorListener);
    }
    private void setValues(int id){
        url= Constants.basicUrl+"/account/"+id+"/product-list";
        method_id= Request.Method.GET;
    }

    public void start(){
        volleyLIbUtils.start();
    }

}
