package com.example.viewmodel

import com.google.gson.annotations.SerializedName

data class Hero(
        @SerializedName("name") var name: String,
        @SerializedName("realname") var realname: String,
        @SerializedName("team") var team: String,
        @SerializedName("firstappearance") var firstappearance: String,
        @SerializedName("createdby") var createdby: String,
        @SerializedName("publisher") var publisher: String,
        @SerializedName("imageurl") var imageurl: String,
        @SerializedName("bio") var bio: String)