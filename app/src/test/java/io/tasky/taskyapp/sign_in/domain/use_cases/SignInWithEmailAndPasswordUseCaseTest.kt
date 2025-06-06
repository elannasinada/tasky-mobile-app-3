package io.tasky.taskyapp.sign_in.domain.use_cases

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import io.tasky.taskyapp.sign_in.data.repository.FakeSignInRepository
import io.tasky.taskyapp.sign_in.domain.repository.SignInRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SignInWithEmailAndPasswordUseCaseTest {
    private lateinit var repository: SignInRepository
    private lateinit var useCase: SignInWithEmailAndPasswordUseCase

    @BeforeEach
    fun setUp() {
        repository = FakeSignInRepository()
        useCase = SignInWithEmailAndPasswordUseCase(repository)
    }

    @Test
    fun `Signing in with correct data, returns the actual user`() = runTest {
        val result = useCase.invoke(
            email = "fellow@user.com",
            password = "Correct",
            repeatedPassword = "Correct"
        )

        assertThat(result.data).isEqualTo(
            userData().copy(
                userId = "randomNewUserId",
            )
        )
    }

    @Test
    fun `Signing in with password not matching, throws exception`() = runTest {
        assertFailure {
            useCase.invoke(
                email = "fellow@user.com",
                password = "Correct",
                repeatedPassword = "Incorrect"
            )
        }
    }

    @Test
    fun `Signing in with no email, throws exception`() = runTest {
        assertFailure {
            useCase.invoke(
                email = "",
                password = "Correct",
                repeatedPassword = "Correct"
            )
        }
    }

    @Test
    fun `Signing in with no password, throws exception`() = runTest {
        assertFailure {
            useCase.invoke(
                email = "fellowuser.com",
                password = "Correct",
                repeatedPassword = "Correct"
            )
        }
    }

    @Test
    fun `Signing in with misspelled email, throws exception`() = runTest {
        assertFailure {
            useCase.invoke(
                email = "fellowuser.com",
                password = "Correct",
                repeatedPassword = "Correct"
            )
        }
    }
}
