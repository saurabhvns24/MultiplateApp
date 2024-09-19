//
//  AboutScreen.swift
//  iosApp
//
//  Created by Saurabh Seth on 18/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("About Device")
        .toolbar{
            ToolbarItem(placement:.primaryAction){
                Button{
                    dismiss()
                }label: {
                    Text("Dome").bold()
                }
            }
        }
    }
    }
}

#Preview {
    AboutScreen()
}
