package com.example.debatematch.domain.debatetag.persistence

import com.example.debatematch.domain.debatetag.DebateTag
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DebateTagRepository: JpaRepository<DebateTag, UUID> {
}