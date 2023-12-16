package com.carlosamaral.demo.enums

enum class ErrorEnum(val msg : String) {
    ID_MUST_BE_GREATER_THAN_ZERO("Id must be greater than zero"),
    FOO_NOT_FOUND("Foo not found")
}