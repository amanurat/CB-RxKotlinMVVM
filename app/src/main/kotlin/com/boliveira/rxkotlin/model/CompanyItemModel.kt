package com.boliveira.rxkotlin.model

import io.mironov.smuggler.AutoParcelable

/**
 * Created by bruno on 03/05/16.
 */


data class CompanyItemModel(private val fromItem: Model.Item): AutoParcelable {
    companion object {

        fun CompaniesFromResponse(response: Model.ODMOrganizations?): Array<CompanyItemModel>? {
            response?.let {
                return it.data.items.map {
                    CompanyItemModel(it)
                }.toTypedArray()
            } ?: return null
        }
    }

    val identifier = fromItem.identifier
    val type = fromItem.type
    val name = fromItem.properties.name
    val description = fromItem.properties.description
    val city = fromItem.properties.city
    val country = fromItem.properties.country
    val twitter = fromItem.properties.twitter
    val imageUrl = fromItem.properties.profileImage
}