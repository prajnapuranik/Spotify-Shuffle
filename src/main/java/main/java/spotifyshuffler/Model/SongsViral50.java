package com.example.spotifyshuffler.Model;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "viral50")
public class SongsViral50 {

    @Id
    private String title;
    private String date;
    private String artist;
    private String region;
    private String chart;
    private int rank;

    public SongsViral50(String title, int rank, String date, String artist, String region, String chart, String trend) {
        this.title = title;
        this.rank = rank;
        this.artist = artist;
        this.region = region;
        this.chart = chart;
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

}
