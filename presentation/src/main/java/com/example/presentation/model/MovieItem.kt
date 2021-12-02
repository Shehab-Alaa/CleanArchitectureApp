package com.example.presentation.model

import android.os.Parcelable
import com.example.presentation.base.BaseParcelable
import com.example.presentation.base.ModelItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem(
    var id: Int,
    var title: String? = null,
    var adult: Boolean? = null,
    var backdropPath: String?  = null,
    var genreIds: List<Int> = arrayListOf(),
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
) : ModelItem() , BaseParcelable, Parcelable {
    override fun unique(): Any = id
}