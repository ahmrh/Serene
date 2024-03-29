package com.ahmrh.serene.domain.model.user

import java.util.Date

data class SelfCareHistory(
    val selfCareId: String,
    val selfCareCategory: String,
    val selfCareName: String,
    val date: Date,
    // TODO: implement feedback
//    val feedback : Feedback

)
fun SelfCareHistory.toMap(): Map<String, Any> {
    val map = mutableMapOf<String, Any>()
    map["selfCareId"] = selfCareId
    map["selfCareCategory"] = selfCareCategory
    map["selfCareName"] = selfCareName
    map["date"] = date.time // Store date as milliseconds since epoch

    return map.toMap()
}