package com.example.spotifyshuffler.Model;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.data.annotation.Id;
import java.util.Date;

@Document(collection = "top200")
public class Songs {

    @Id
    private String title;
    int rank;
    private String date;
    private String artist;
    private String region;
    private String chart;
    private Double streams;


    public Songs(String title, int rank, String date, String artist, String region, String chart, Double streams) {
        this.title = title;
        this.rank = rank;
        this.artist = artist;
        this.region = region;
        this.chart = chart;
        this.streams = streams;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public Double getStreams() {
        return streams;
    }

    public void setStreams(Double streams) {
        this.streams = streams;
    }

    public String toString(){return "title:" + this.title +", rank:"+
            this.rank + ", date:" + this.date + ", artist:" + this.artist +
            ", region:"  + this.region + ", chart:" + this.chart +
            ", streams:" + this.streams;
        }
}
