package com.memberservice.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
class Member (
) {
    @Id
    @GeneratedValue
    val id: Long? = null

    /* 중복 불가능 */
    var email: String = ""

    var password: String = ""

    constructor(email: String, password: String) : this() {
        this.email = email
        this.password = password
    }
}