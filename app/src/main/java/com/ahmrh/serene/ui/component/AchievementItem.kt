package com.ahmrh.serene.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmrh.serene.R
import com.ahmrh.serene.ui.theme.SereneTheme

@Composable
fun AchievementItem(
    onClick: () -> Unit = {},
    withTitle: Boolean = false,
    variant: Int = 2,
//    achievement: Achievement? = null
) {

    when (variant) {
        1 -> {

            Box(
                modifier = Modifier
                    .size(104.dp)
            ){

                Box(
                    Modifier
                        .size(120.dp)
                        .background(
                            Color.Transparent,
                            shape =
                            RoundedCornerShape(
                                24.dp
                            )
                        )
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.serene_placeholder_achievement
                        ),
                        contentDescription = null,
                        Modifier
                            .wrapContentSize(
                                unbounded = true,
                                align = Alignment.BottomCenter
                            )
                            .size(140.dp)
                    )
                }
                // like some layer to cover the clickable
                Box(Modifier.fillMaxSize().clip(
                    RoundedCornerShape(24.dp)
                ).clickable { onClick() } ){}
            }
        }

        2 -> {
            Box (
                Modifier.size(width = 160.dp, height = 196.dp),
                contentAlignment = Alignment.Center
            ){


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        8.dp
                    ),
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp
                        )
                ) {

                    Box(
                        Modifier
                            .size(160.dp)
                            .background(
                                Color.Transparent,
                                shape = RoundedCornerShape(
                                    24.dp
                                )
                            )
                    ) {
                        Image(
                            painterResource(
                                id = R.drawable.serene_placeholder_achievement
                            ),
                            contentDescription = null,
                            Modifier
                                .wrapContentSize(
                                    unbounded = true,
                                    align = Alignment.BottomCenter
                                )
                                .size(200.dp)
                        )
                    }
                    Text(
                        text = "ACHIEVEMENT NAME",
                        style = MaterialTheme.typography.titleSmall
                    )


                }
                // like some layer to cover the clickable
                Box(
                    modifier = Modifier.fillMaxSize().clip(
                        RoundedCornerShape(24.dp)
                    ).clickable { onClick() }
                )

            }
        }

        else -> {
            Text("Unidentified Achievement Item")
        }
    }


}
@Preview(name = "Light Mode",  showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AchievementItemPreview() {
    SereneTheme {
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(
                16.dp
            )
        ) {

            AchievementItem(variant = 1)
            AchievementItem(variant = 2)
        }
    }
}