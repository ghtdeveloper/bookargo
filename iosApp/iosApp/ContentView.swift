import SwiftUI
import WebKit

struct ContentView: View {
    @StateObject private var webViewModel = WebViewModel()
    
    var body: some View {
        NavigationView {
            WebView(url: URL(string: "https://www.bookargo.com/")!, webView: $webViewModel.webView)
                .toolbar {
                    ToolbarItem(placement: .navigationBarTrailing) {
                        Button(action: {
                            webViewModel.reloadPage()
                        }) {
                            Image(systemName: "arrow.clockwise")
                        }
                    }
                }
                .navigationTitle("Bookargo")
        }
    }
}


import SwiftUI
import WebKit

struct WebView: UIViewRepresentable {
    let url: URL
    @Binding var webView: WKWebView
    
    func makeUIView(context: Context) -> WKWebView {
        webView.navigationDelegate = context.coordinator
        let request = URLRequest(url: url)
        webView.load(request)
        return webView
    }
    
    func updateUIView(_ uiView: WKWebView, context: Context) { }
    
    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    class Coordinator: NSObject, WKNavigationDelegate {
        var parent: WebView
        init(_ parent: WebView) {
            self.parent = parent
        }
    }
}

import WebKit
import SwiftUI

class WebViewModel: ObservableObject {
    @Published var webView = WKWebView()
    
    func reloadPage() {
        webView.reload()
    }
}

