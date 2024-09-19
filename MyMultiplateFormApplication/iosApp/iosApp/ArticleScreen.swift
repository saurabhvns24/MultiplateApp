//
//  ArticleScreen.swift
//  iosApp
//
//  Created by Saurabh Seth on 18/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import shared
import SwiftUI
    
extension ArticleScreen {
    @MainActor
    class ArticleViewModelWrapper:ObservableObject {
        let articleViewModel:ArticleViewModel
        init() {
            articleViewModel = ArticleInjector().articleViewModel
            articleState = articleViewModel.articleState.value
        }
        
        @Published var articleState : ArticleState
        func startObserving() {
            Task {
                for await articlesS in articleViewModel.articleState {
                    self.articleState = articlesS
                }
            }
        }
    }
}
struct ArticleScreen: View {
    @ObservedObject private(set) var articleViewModel:ArticleViewModelWrapper
    var body: some View {
        VStack{
            AppBar()
            if articleViewModel.articleViewModel.artcleState.loading{
                Loader()
            }
            if let error = articleViewModel.articleViewModel.artcleState.error{
                ErrorMessage(message:error)
            }
            if(!articleViewModel.articleViewModel.artcleState.articles.isEmpty){
                ScrollView{
                    LazyVStack(spacing:10){
                        ForEach(articleViewModel.articleViewModel.artcleState.articles,id: \.self){
                            article in ArticleItemView(article:article)
                        }
                    }
                }
            }
            
        }
        .onAppear{
            self.viewModel.startObserving()
        }
    }
}
struct AppBar:View {
    var body: some View {
        Text("Articles").font(.largeTitle).fontWeight(.bold)
    }
}
struct ArticleItemView:View {
    var article:Article
    var body: some View {
        VStack (alignment: .leading, spacing: 8){
            AsyncImage(url: URL(string:  article.imageUrl ?? "")){
                phase in if phase.image != nil{
                    phase.image!.resizable().aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(article.title).font(.title).fontWeight(.bold)
            Text(article.description)
            Text(article.date).frame(maxWidth: .infinity,alignment: .trailing).foregroundStyle(.gray)
        }.padding(16)
    }
}

struct Loader:View {
    var body: some View {
        ProgressView()
    }
}
struct ErrorMessage:View {
    var message:String
    var body: some View {
        Text(message).font(.title)
    }
}
