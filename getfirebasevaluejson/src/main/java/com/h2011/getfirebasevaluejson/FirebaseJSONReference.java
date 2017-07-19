package com.h2011.getfirebasevaluejson;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Harsh on 18-07-2017.
 */

public class FirebaseJSONReference {
    Context context;
    String FirebaseRef;
    String FirebaseDatabaseURL;

    String auth;

    RequestQueue queue;

    ResponseListener responseListener;

    public FirebaseJSONReference(Context context){
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }

    public void setFirebaseRef(String firebaseRef) {
        FirebaseRef = firebaseRef;
    }

    public void setFirebaseDatabaseURL(String firebaseDatabaseURL) {
        FirebaseDatabaseURL = firebaseDatabaseURL;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setResponseListener(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }
    StringRequest request;
    public void build(){
        request = new StringRequest(Request.Method.GET, FirebaseDatabaseURL + FirebaseRef + ".json?auth=" + auth, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(responseListener!=null){
                    responseListener.onResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
    public void execute(){
        if(request!=null) {
            queue.add(request);
        }
    }
}
