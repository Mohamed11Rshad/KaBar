package com.loc.newsapp.presentation.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.Dimens.ArticleImageHeight
import com.loc.newsapp.presentation.Dimens.MediumPadding1
import com.loc.newsapp.presentation.details.components.DetailsTopBar

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBackClick = { navigateUp() },
            onBookmarkClick = { event(DetailsEvent.UpsertDeleteArticle(article)) },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.type = "text/plain"
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1,
            )
        ) {

            item {

                AsyncImage(
                    model = ImageRequest.Builder(context).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.text_title)
                )

                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.body)
                )

            }

        }

    }

}
//
//@Preview(showBackground = true)
//@Composable
//fun DetailsScreenPreview() {
//    NewsAppTheme {
//        DetailsScreen(
//            article = Article(
//                source = Source(id = "wired", name = "Wired"),
//                author = "Joel Khalili",
//                title = "Fresh Bitcoin Hype Shows Crypto Just Can’t Help Itself",
//                description = "After crashes, scandals, and SBF’s guilty verdict, many hoped the crypto industry would grow up. Speculation around the arrival of a spot bitcoin ETF shows old hype dies hard.",
//                url = "https://www.wired.com/story/bitcoin-etf-crypto-investments/",
//                urlToImage = "https://media.wired.com/photos/65668f0cb38d7a2373721a48/191:100/w_1280,c_limit/Crpyto-Can't-Help-Itself-Business-1400047284.jpg",
//                publishedAt = "2023-11-29T12:00:00Z",
//                content = "The prospect that US residents may soon be able to invest in bitcoin through their brokerage, as if it were a regular stock, has prompted a fresh round of hype in crypto circlesand a surge in crypto … [+2137 chars]"
//            ),
//            event = {},
//            navigateUp = {}
//        )
//    }
//
//}