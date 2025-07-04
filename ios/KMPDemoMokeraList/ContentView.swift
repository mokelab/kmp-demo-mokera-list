//
//  ContentView.swift
//  KMPDemoMokeraList
//
//  Created by fkm on 2025/07/02.
//

import SwiftUI
import kmpKit

struct ContentView: View {
    @StateObject private var viewModel: MokeraListViewModel
    
    init(mokeraRepository: MokeraRepository) {
        self._viewModel = StateObject(
            wrappedValue: MokeraListViewModel(
                mokeraRepository: mokeraRepository
            )
        )
    }
    
    var body: some View {
        switch viewModel.uiState {
        case .initial:
            ProgressView().task {
                viewModel.load()
            }
        case .loading:
            ProgressView()
        case .success(let mokeras):
            MokeraListContent(mokeras: mokeras)
        case .error:
            Text("Error")
        }
    }
}

struct MokeraListContent: View {
    private let mokeras: [Mokera]
    
    init(mokeras: [Mokera]) {
        self.mokeras = mokeras
    }
    
    var body: some View {
        List {
            ForEach(self.mokeras, id: \.self) { mokera in
                VStack(alignment: .leading) {
                    Text(mokera.name)
                    Text("id=\(mokera.id)")
                }
            }
        }
    }
}

#Preview {
//    ContentView(mokeraRepository: nil)
}
