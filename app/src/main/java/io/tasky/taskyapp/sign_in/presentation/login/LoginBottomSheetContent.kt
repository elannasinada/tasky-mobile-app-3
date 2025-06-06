package io.tasky.taskyapp.sign_in.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.tasky.taskyapp.R
import io.tasky.taskyapp.core.presentation.widgets.DefaultTextButton
import io.tasky.taskyapp.core.presentation.widgets.DefaultTextField

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun LoginBottomSheetContent(
    onLoginWithEmailAndPassword: (String, String) -> Unit,
) {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6F),
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.enter_your_information),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            SignInTextFields(email, password)

            DefaultTextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 72.dp, vertical = 16.dp),
                text = stringResource(id = R.string.sign_in),
                onClick = {
                    onLoginWithEmailAndPassword.invoke(email.value, password.value)
                },
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
private fun SignInTextFields(
    email: MutableState<String>,
    password: MutableState<String>
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTextField(
            modifier = Modifier.padding(8.dp),
            text = email.value,
            icon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "LockIcon"
                )
            },
            label = stringResource(id = R.string.email),
            onValueChange = {
                email.value = it
            }
        )

        DefaultTextField(
            modifier = Modifier.padding(8.dp),
            text = password.value,
            isPassword = true,
            icon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "LockIcon"
                )
            },
            label = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Password,
            onValueChange = {
                password.value = it
            }
        )
    }
}
