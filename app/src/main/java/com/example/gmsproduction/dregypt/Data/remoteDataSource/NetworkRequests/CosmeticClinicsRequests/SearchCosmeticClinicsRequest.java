package com.example.gmsproduction.dregypt.Data.remoteDataSource.NetworkRequests.CosmeticClinicsRequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.gmsproduction.dregypt.Data.remoteDataSource.VolleyLIbUtils;
import com.example.gmsproduction.dregypt.utils.Constants;

import java.util.HashMap;

/**
 * Created by mohmed mostafa on 23/04/2018.
 */

public class SearchCosmeticClinicsRequest {

    VolleyLIbUtils volleyLIbUtils;
    String url;
    int methodId;

    public SearchCosmeticClinicsRequest(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener,int page){
        setValues(page);
        volleyLIbUtils=new VolleyLIbUtils(context,methodId,url,listener,errorListener);
    }
    private void setValues(int page){
        url= Constants.basicUrl+"/cosmetic-clinics/search?page="+page;
        methodId= Request.Method.POST;
    }

    public void setBody(HashMap body){
        volleyLIbUtils.setParams(body);
    }
    public void start(){
        volleyLIbUtils.start();
    }
}
