package io.tasky.taskyapp.sign_in.domain.use_cases

import io.tasky.taskyapp.sign_in.domain.model.UserData

fun userData(): UserData {
    return UserData(
        userId = "randomUserId",
        userName = "Fellow User",
        email = "fellow@user.com",
        profilePictureUrl = null
    )
}
