//
//  MokeraListViewModel.swift
//  KMPDemoMokeraList
//
//  Created by fkm on 2025/07/02.
//
import SwiftUI
import kmpKit

class MokeraListViewModel: ObservableObject {
    enum UiState {
        case initial
        case loading
        case success(mokeras: [Mokera])
        case error
    }
    private let mokeraRepository: MokeraRepository
    
    @Published private(set) var uiState: UiState = .initial

    init(mokeraRepository: MokeraRepository) {
        self.mokeraRepository = mokeraRepository
    }

    @MainActor
    func load() {
        self.uiState = .loading
        Task {
            do {
                let mokeras = try await self.mokeraRepository.getAll()
                self.uiState = .success(mokeras: mokeras)
            } catch {
                self.uiState = .error
            }
        }
    }
}
