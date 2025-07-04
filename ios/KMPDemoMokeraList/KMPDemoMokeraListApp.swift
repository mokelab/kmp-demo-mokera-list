//
//  KMPDemoMokeraListApp.swift
//  KMPDemoMokeraList
//
//  Created by fkm on 2025/07/02.
//

import SwiftUI
import kmpKit

@main
struct KMPDemoMokeraListApp: App {
    private let mokeraRepository: MokeraRepository
    private let networkMokeraDataSource: NetworkMokeraDataSource
    init() {
        self.networkMokeraDataSource = HttpMokeraDataSource(
            baseUrl: "https://mokelab.github.io/kmp-demo-mokera-list",
            client: ModuleKt.createKtorClient(),
            json: ModuleKt.createJson(),
            dispatcher: ModuleKt.createIoDispatcher()
        )
        self.mokeraRepository = OnlineMokeraRepository(
            dataSource: self.networkMokeraDataSource
        )
    }
    var body: some Scene {
        WindowGroup {
            ContentView(
                mokeraRepository: self.mokeraRepository
            )
        }
    }
}
