package com.example.mymultiplateformapplication.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import com.example.mymultiplateformapplication.article.application.Article
import com.example.mymultiplateformapplication.article.presentation.ArticleViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ArticleScreen(
    onAboutScreenClick: () -> Unit,
    articleViewModel: ArticleViewModel = getViewModel()//this is coming from koin library.,
) {
    val articleState = articleViewModel.articleState.collectAsState()
    Column {
        AppBar(onAboutScreenClick)
        if (articleState.value.error != null) {
            ErrorMessage(articleState.value.error!!)
        }
        if (articleState.value.articles.isNotEmpty()) {
            ArticleListView(articleViewModel)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onAboutScreenClick: () -> Unit) {
    TopAppBar(title = { Text(text = "Articles") }, actions = {
        IconButton(onClick = onAboutScreenClick) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "About Device Button"
            )
        }
    })
}

//@Composable
//fun Loader() {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        CircularProgressIndicator(
//            modifier = Modifier.width(64.dp),
//            color = MaterialTheme.colorScheme.surfaceVariant,
//            trackColor = MaterialTheme.colorScheme.secondary
//        )
//    }
//}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArticleListView(viewModel: ArticleViewModel) {
    // Create a pull refresh state
    val refreshState = rememberPullRefreshState(
        refreshing = viewModel.articleState.collectAsState().value.loading,
        onRefresh = {
            viewModel.getArticle(true)
        }
    )

    // Use a Box to allow for pull-to-refresh
    val articles: List<Article> = viewModel.articleState.collectAsState().value.articles
    Box(modifier = Modifier.pullRefresh(refreshState)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articles) { article ->
                ArticleItemView(article = article)
            }
        }

        // Add the PullRefreshIndicator
        PullRefreshIndicator(
            refreshing = viewModel.articleState.collectAsState().value.loading,
            state = refreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}


//@Composable
//fun ArticleListView(viewModel: ArticleViewModel) {
//
//    Pu(state = PullRefreshState(viewModel.articleState.value.loading), onRefresh = {
//        viewModel.getArticle(true)
//    }) {
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(viewModel.articleState.value.articles) { article ->
//                ArticleItemView(article = article)
//            }
//        }
//    }
//
//}

@Composable
fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(model = article.imageUrl, contentDescription = null)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = article.description,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.align(Alignment.End),
            text = article.date,
            style = TextStyle(color = Color.Gray)
        )
    }
}

@Composable
fun ErrorMessage(error: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = error, textAlign = TextAlign.Center, fontSize = 28.sp
        )
    }
}