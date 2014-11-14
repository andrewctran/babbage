package com.num.myspeedtest.models;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Traceroute implements BaseModel {

    List<TracerouteEntry> traceroutelist = new ArrayList<TracerouteEntry>();
    int startindex, endindex;

    public Traceroute(int startindex, int endindex) {
        this.startindex = startindex;
        this.endindex = endindex;
    }

//    public List<TracerouteEntry> getTraceroutelist() {
//        return traceroutelist;
//    }

    public void addToList(TracerouteEntry trace_entry) {

        traceroutelist.add(trace_entry);
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();

        try {
            JSONArray array = new JSONArray();
            for(TracerouteEntry entry : traceroutelist) {
                array.put(entry.toJSON());
            }
            obj.put("entries", array);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return obj;
    }

    public List<TracerouteEntry> getDisplayData() {

        Collections.sort(traceroutelist);
        return traceroutelist;

    }

}