package io.tasky.taskyapp.sign_in.data.auth_client

import android.content.Intent
import android.content.IntentSender
import io.tasky.taskyapp.sign_in.domain.model.SignInResult
import io.tasky.taskyapp.sign_in.domain.model.UserData

/**
 * Class that communicates with the Firebase Authentication services.
 */
interface GoogleAuthClient {
    suspend fun signInWithEmailAndPassword(email: String, password: String): SignInResult
    suspend fun loginWithEmailAndPassword(email: String, password: String): SignInResult
    suspend fun signIn(): IntentSender?
    suspend fun getSignInResultFromIntent(intent: Intent): SignInResult
    fun getSignedInUser(): UserData?
    suspend fun logout()
}
