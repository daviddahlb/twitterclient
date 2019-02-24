package com.codepath.apps.restclienttemplate.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
@Entity
public class Tweet {

    @ColumnInfo
    public String body;
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo
    public String createdAt;
    @ColumnInfo
    public User user;

    // Empty constructor for Parceler Library
    public Tweet() {
    }

    //takes a json object and turns into tweet/user object
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();

        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));

        return tweet;
    }

    public static List<Tweet> createTweetList(JSONObject jsonObject, int i) {
        List<Tweet> list = new ArrayList<Tweet>();



        return list;
    }

    public String getFormattedTimestamp(){
        return TimeFormatter.getTimeDifference(createdAt);
    }
}
