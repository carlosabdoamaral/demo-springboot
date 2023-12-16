package com.carlosamaral.demo.controllers

import com.carlosamaral.demo.enums.ErrorEnum
import com.carlosamaral.demo.models.FooModel
import com.carlosamaral.demo.services.FooService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@Controller
@RestController
@RequestMapping("/foo")
class FooController (
    @Autowired val fooService: FooService
){
    @GetMapping("/find")
    fun findAll() : ResponseEntity<Any> {
        return try {
            val res = fooService.findAll();
            ResponseEntity(res, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @GetMapping("/find/{id}")
    fun findAllById(@PathVariable id: Long) : ResponseEntity<Any> {
        if(id <= 0) return ResponseEntity(ErrorEnum.ID_MUST_BE_GREATER_THAN_ZERO.msg, HttpStatus.BAD_REQUEST)

        return try {
            val res = fooService.findById(id)
            ResponseEntity(res, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("/update")
    fun update(@RequestBody @Valid body: FooModel) : ResponseEntity<Any> {
        if(body.id == null) return ResponseEntity(ErrorEnum.ID_MUST_BE_GREATER_THAN_ZERO.msg, HttpStatus.BAD_REQUEST)

        val fooFounded : Optional<FooModel>
        try {
            fooFounded = fooService.findById(body.id)
            if (fooFounded.isEmpty) return ResponseEntity(ErrorEnum.FOO_NOT_FOUND.msg, HttpStatus.BAD_REQUEST)
        } catch (e: Exception) {
            return ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return try {
            val res = fooService.save(body)
            ResponseEntity(res, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("/save")
    fun save(@RequestBody @Valid body: FooModel) : ResponseEntity<Any> {
        return try {
            val res = fooService.save(body)
            ResponseEntity(res, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("/update-or-save")
    fun updateOrSave(@RequestBody @Valid body: FooModel) : ResponseEntity<Any>{
        return when {
            body.id == null -> this.save(body)
            else -> this.update(body)
        }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id : Long) : ResponseEntity<Any> {
        if(id <= 0) return ResponseEntity(ErrorEnum.ID_MUST_BE_GREATER_THAN_ZERO.msg, HttpStatus.BAD_REQUEST)

        val fooFounded : Optional<FooModel>
        try {
            fooFounded = fooService.findById(id)
            if (fooFounded.isEmpty) return ResponseEntity(ErrorEnum.FOO_NOT_FOUND.msg, HttpStatus.BAD_REQUEST)
        } catch (e: Exception) {
            return ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return try {
            fooService.deleteById(id)
            val fooId = fooFounded.get().id
            ResponseEntity("Foo #$fooId deleted!", HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(e.localizedMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/delete")
    fun deleteAllById(@RequestBody body : List<Long>): ResponseEntity<Any> {
        val deletedIDs : HashSet<String> = hashSetOf()

        for(id in body) {
            try {
                fooService.deleteById(id)
                deletedIDs.add("$id deleted")
            } catch (e: Exception) {
                continue
            }
        }

        return ResponseEntity(deletedIDs, HttpStatus.OK)
    }
}