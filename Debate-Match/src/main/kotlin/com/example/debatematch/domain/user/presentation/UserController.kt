package com.example.debatematch.domain.user.presentation

import com.example.debatematch.domain.user.presentation.dto.UserSignUpRequest
import com.example.debatematch.domain.user.service.UserSignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userSignUpService: UserSignUpService
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody userSignUpRequest: UserSignUpRequest): UUID? {
        return userSignUpService.execute(userSignUpRequest)
    }

}