package com.example.data.mapper

import com.example.data.model.generateDomainModel
import com.example.data.model.generateEntityModel
import org.junit.Assert.*
import org.junit.Test

class MovieEntityMapperTest{

    private val movieEntityMapper = MovieEntityMapper()

    @Test
    fun `map from domain to entity` () {

        val domainModel = generateDomainModel()
        val expectedEntityModel = generateEntityModel()

        val entityModel = movieEntityMapper.mapToEntity(domainModel)

        assertEquals(expectedEntityModel.id,entityModel.id)
        assertEquals(expectedEntityModel.title,entityModel.title)
        assertEquals(expectedEntityModel.voteAverage,entityModel.voteAverage)
        assertEquals(expectedEntityModel.voteCount,entityModel.voteCount)
        assertEquals(expectedEntityModel.backdropPath,entityModel.backdropPath)
        assertEquals(expectedEntityModel.posterPath,entityModel.posterPath)
        assertEquals(expectedEntityModel.releaseDate,entityModel.releaseDate)
    }

    @Test
    fun `map from entity to domain`  (){

        val entityModel = generateEntityModel()
        val expectedDomainModel = generateDomainModel()

        val domainModel = movieEntityMapper.mapToDomain(entityModel)

        assertEquals(expectedDomainModel.id,domainModel.id)
        assertEquals(expectedDomainModel.title,domainModel.title)
        assertEquals(expectedDomainModel.voteAverage,domainModel.voteAverage)
        assertEquals(expectedDomainModel.voteCount,domainModel.voteCount)
        assertEquals(expectedDomainModel.backdropPath,domainModel.backdropPath)
        assertEquals(expectedDomainModel.posterPath,domainModel.posterPath)
        assertEquals(expectedDomainModel.releaseDate,domainModel.releaseDate)
    }

}