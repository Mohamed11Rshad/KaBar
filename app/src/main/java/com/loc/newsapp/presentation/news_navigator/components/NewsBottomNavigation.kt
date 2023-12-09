package com.loc.newsapp.presentation.news_navigator.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.Dimens.IconSize
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp,
    ) {

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(id = R.color.body),
                    unselectedTextColor = colorResource(id = R.color.body),
                    indicatorColor = MaterialTheme.colorScheme.background,
                    ),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(IconSize)
                        )
                        
                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                        Text(
                            text = item.text,
                            style = MaterialTheme.typography.labelSmall
                        )

                    }
                },
            )
        }

    }


}

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text: String,
)

@Preview(showBackground = true)
@Composable
fun NewsBottomNavigationPreview() {
    NewsAppTheme {
        NewsBottomNavigation(
            items = listOf(
                BottomNavigationItem(
                    icon = R.drawable.ic_home,
                    text = "Home"
                ),
                BottomNavigationItem(
                    icon = R.drawable.ic_search,
                    text = "Search"
                ),
                BottomNavigationItem(
                    icon = R.drawable.ic_bookmark,
                    text = "Bookmark"
                ),
            ),
            selected = 0,
            onItemClick = {}
        )
    }
}