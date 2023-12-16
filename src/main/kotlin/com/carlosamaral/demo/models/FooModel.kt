package com.carlosamaral.demo.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity(name = "foo")
class FooModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null

    @NotNull
    @Size(max = 100)
    var title : String = ""
}