package com.example.movieinfoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary {

    private String imdbID;
    private String Title;
    private String Plot;

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public MovieSummary(String imdbID, String title, String plot) {
        this.imdbID = imdbID;
        this.Title = title;
        this.Plot = plot;
    }



    public MovieSummary() {
    }


    @JsonProperty("Title")
    public String getTitle() {
        return Title;
    }

    @JsonProperty("Title")
    public void setTitle(String Title) {
        this.Title = Title;
    }

    @JsonProperty("Plot")
    public String getPlot() {
        return Plot;
    }

    @JsonProperty("Plot")
    public void setPlot(String Plot) {
        this.Plot = Plot;
    }

    @Override
    public String toString() {
        return "MovieSummary{" +
                "imdbID='" + imdbID + '\'' +
                ", Title='" + Title + '\'' +
                ", Plot='" + Plot + '\'' +
                '}';
    }
}
