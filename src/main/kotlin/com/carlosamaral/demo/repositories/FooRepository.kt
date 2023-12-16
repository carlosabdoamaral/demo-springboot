package com.carlosamaral.demo.repositories

import com.carlosamaral.demo.models.FooModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FooRepository : JpaRepository<FooModel, Long>{
}