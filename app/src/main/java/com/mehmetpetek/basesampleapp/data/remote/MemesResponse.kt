package com.mehmetpetek.basesampleapp.data.remote

import androidx.compose.runtime.Stable

@Stable
data class MemesResponse(
    var success: String,
    var data: DataResponse,
)

@Stable
data class DataResponse(
    var memes: List<Memes>,
)

@Stable
data class Memes(
    var id: String,
    var name: String,
    var url: String,
    var width: Int,
    var height: Int,
    var box_count: Int
)