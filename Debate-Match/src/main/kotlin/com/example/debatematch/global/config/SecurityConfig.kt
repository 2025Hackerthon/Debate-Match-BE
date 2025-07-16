package com.example.debatematch.global.config

import com.example.debatematch.global.error.GlobalExceptionFilter
import com.example.debatematch.global.security.jwt.JwtTokenFilter
import com.example.debatematch.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenProvider: JwtTokenProvider
) {
    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf{it.disable()}
            .formLogin{it.disable()}
            .httpBasic{it.disable()}
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

            .authorizeHttpRequests {
                it
                    .requestMatchers(CorsUtils::isCorsRequest).permitAll()
                    .requestMatchers("/swagger-ui/index.html",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**",
                        "/swagger-ui.html",
                        "/user/signup",
                        "/user/login",
                        "/error",
                        "debate/wait"
                    ).permitAll()
                    .requestMatchers(
                        "/debate/create"
                    ).authenticated()
                    .anyRequest().authenticated()
            }

                http
                    .addFilterBefore(JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
                    .addFilterBefore(GlobalExceptionFilter(objectMapper), JwtTokenFilter::class.java)

        return http.build()
    }


    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}
