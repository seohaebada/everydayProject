package com.accountserver.infrastructure
import com.accountserver.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account?
}