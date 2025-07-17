package com.example.debatematch.domain.user.presentation

import com.example.debatematch.domain.user.presentation.dto.UserEditEducationRequest
import com.example.debatematch.domain.user.presentation.dto.UserLoginRequest
import com.example.debatematch.domain.user.presentation.dto.UserSignUpRequest
import com.example.debatematch.domain.user.service.UserCheckIdService
import com.example.debatematch.domain.user.service.UserEditEducationService
import com.example.debatematch.domain.user.service.UserLoginService
import com.example.debatematch.domain.user.service.UserQueryInfoService
import com.example.debatematch.domain.user.service.UserResignService
import com.example.debatematch.domain.user.service.UserSignUpService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userSignUpService: UserSignUpService,
    private val userResignService: UserResignService,
    private val userLoginService: UserLoginService,
    private val userQueryInfoService: UserQueryInfoService,
    private val userEditEducationService: UserEditEducationService,
    private val userCheckIdService: UserCheckIdService

) {
    @PostMapping("/signup")
    fun signUp(
        @RequestBody userSignUpRequest: UserSignUpRequest
    ): UUID? {
        return userSignUpService.execute(userSignUpRequest)
    }

    @DeleteMapping("/resign")
    fun resign() {
        userResignService.execute()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody request: UserLoginRequest
    ) = userLoginService.execute(request)

    @GetMapping("/info")
    fun getUserInfo() = userQueryInfoService.execute()

    @PatchMapping("/edit")
    fun edit(request: UserEditEducationRequest) = userEditEducationService.execute(request)

    @GetMapping("/check")
    fun check(@RequestParam id: String) = userCheckIdService.execute(id)
}
