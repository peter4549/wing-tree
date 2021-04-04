package com.duke.orca.android.kotlin.wingtree.study.data

import com.duke.orca.android.kotlin.wingtree.user.data.User

data class Study (
    var bookmark: Boolean,
    var color: Int,
    val id: String,
    var name: String,
    var users: ArrayList<User>
)