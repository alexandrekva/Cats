package com.example.cats.feature_cats.domain.utils

import com.example.cats.feature_cats.data.remote.dto.Data

class FilterCatDataList {
    companion object {
        fun onlyImages(list: List<Data>): List<Data> {
            return list.filter { data ->
                data.images?.any { it.type != "video/mp4" } ?: false
            }
        }
    }
}