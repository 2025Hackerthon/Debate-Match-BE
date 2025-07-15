package com.example.debatematch.domain.tag.persistence

import com.example.debatematch.domain.tag.Tag
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TagRepository:JpaRepository<Tag,UUID> {
}