//
//  AboutListView.swift
//  iosApp
//
//  Created by Saurabh Seth on 15/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import shared
import SwiftUI

struct AboutListView: View {
    private struct RowItem:Hashable{
        let title:String
        let subtitle:String
    }
    private let items:[RowItem]={
        let platForm = Platform()
        platForm.logSystemInfo()
        var result : [RowItem] = [
            .init(title: "Operating System", subtitle:"\(platForm.osName) \(platForm.osVersion)"),
            .init(title:"Device", subtitle: platForm.deviceModel),
            .init(title: "Density", subtitle: "@\(platForm.density)x")
    ]
        return result
    }()
    var body: some View{
        List{
            ForEach(items,id: \.self){
                item in VStack(alignment: .leading){
                    Text(item.title).font(.footnote).foregroundStyle(.secondary)
                    Text(item.title).font(.footnote).foregroundStyle(.primary)
                }.padding(.vertical,4)
            }
        }
    }
}

#Preview {
    AboutListView()
}
