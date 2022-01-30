package com.example.myapplication.root.local

import com.example.myapplication.root.domain.BlogModel
import com.example.myapplication.root.mapper.Mapper
import javax.inject.Inject

class LocalMapper @Inject constructor():Mapper<BlogEntity,BlogModel> {
    override fun mapFromEntity(entity: BlogEntity): BlogModel {
        return BlogModel(
            entity.id,
            entity.title,
            entity.body,
            entity.image,
            entity.category
        )
    }

    override fun mapToEntity(domainModel: BlogModel): BlogEntity {
        return BlogEntity(
            domainModel.id,
            domainModel.title,
            domainModel.body,
            domainModel.image,
            domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogEntity>) :List<BlogModel>{
        return entities.map {
            mapFromEntity(it)
        }
    }
}