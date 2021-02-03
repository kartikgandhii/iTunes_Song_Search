package com.example.itunessongsearch

import com.example.itunessongsearch.model.DataModel
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class ItunesResponse {
    @SerializedName("resultCount")
    @Expose
    private var resultCount: Int? = null

    @SerializedName("results")
    @Expose
    private var results: List<DataModel?>? = null

    fun getResultCount(): Int? {
        return resultCount
    }

    fun setResultCount(resultCount: Int?) {
        this.resultCount = resultCount
    }

    fun getResults(): List<DataModel?>? {
        return results
    }

    fun setResults(results: List<DataModel?>?) {
        this.results = results
    }
}