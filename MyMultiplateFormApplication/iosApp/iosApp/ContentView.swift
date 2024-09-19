import SwiftUI
import shared

struct ContentView: View {
//	let greet = Greeting().greet()
    @State private var shouldopenAbout = false
	var body: some View {
        let articlesScreen = ArticleScreen(viewModel : init())
        NavigationStack{
            ArticleScreen(viewModel: .init())
            articlesScreen
                .toolbar{
                    ToolbarItem{
                        Button {
                            shouldopenAbout = true
                        }label: {
                            Label("About",systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }.popover(isPresented: $shouldopenAbout){
                            AboutScreen()
                        }
                    }
                }
        }.refreshable {
            articlesScreen.viewModel.articleViewModel.getArticle(true)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
