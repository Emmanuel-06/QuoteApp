package com.example.quoteapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuoteHomeScreen (
    viewModel: QuoteViewModel = hiltViewModel()
) {

    val quoteState = viewModel.quoteData.value

    when {
        quoteState.loading -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }

        quoteState.exception != null -> Text(text = "Error: ${quoteState.exception?.localizedMessage}")

        quoteState.data != null -> {

            val quote = quoteState.data!!

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxHeight()
            ) {
               Surface(
                   color = Color(0xFFE8E5FF),
                   shape = RoundedCornerShape(18.dp),
                   contentColor = Color(0xFF000000),
                   modifier = Modifier
                       .height(360.dp)
                       .fillMaxWidth()
                       .border(
                           width = 2.dp, shape = RoundedCornerShape(18.dp), color = Color(
                               0xFFCDBFF7
                           )
                       )
               ) {
                   Column(
                       modifier = Modifier.padding(40.dp)
                   ) {
                       Text(
                           text = quote.data.quote,
                           fontSize = 20.sp,
                           modifier = Modifier.weight(1f)
                       )
                       Spacer(modifier = Modifier.height(18.dp))

                       Text(
                           text = "—${quote.data.author}",
                           fontSize = 16.sp,
                           fontWeight = FontWeight.Bold
                       )
                   }
               }

                Spacer(modifier = Modifier.height(60.dp))

                Button(
                    onClick = { viewModel.getQuote() },
                    colors = ButtonDefaults.buttonColors(Color(0xFF5218A5))
                ) {
                    Text(text = "Next Quote")
                }
            }
        }

    }
}