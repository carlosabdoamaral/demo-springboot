package com.carlosamaral.demo.services

import com.carlosamaral.demo.models.FooModel
import com.carlosamaral.demo.repositories.FooRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FooService (
    @Autowired val fooRepository: FooRepository
) {
    fun findAll() : List<FooModel> {
        return fooRepository.findAll()
    }

    fun findById(id: Long) : Optional<FooModel> {
        return fooRepository.findById(id);
    }

    fun save(body: FooModel) : FooModel {
        return fooRepository.save(body);
    }

    fun deleteById(id : Long) : Any {
        return fooRepository.deleteById(id)
    }
}