package com.accountserver.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "account")
@Entity
class Account(
    @Id
    @GeneratedValue
    private var id: Long? = null,

    @Column(unique = true)
    private val email: String? = null,

    @Column(unique = true)
    private val nickname: String? = null,

    private val password: String? = null,

    private val emailVerified: Boolean = false,

    private val emailCheckToken: String? = null,

    private val emailCheckTokenGeneratedAt: LocalDateTime? = null,

    private val joinedAt: LocalDateTime? = null,

    private val bio: String? = null,

    private val url: String? = null,

    private val occupation: String? = null,

    private val location: String? = null,

    @Lob
    private val profileImage: String? = null,

    private val studyCreatedByEmail: Boolean = false,

    private val studyCreatedByWeb: Boolean = true,

    private val studyEnrollmentResultByEmail: Boolean = false,

    private val studyEnrollmentResultByWeb: Boolean = true,

    private val studyUpdatedByEmail: Boolean = false,

    private val studyUpdatedByWeb: Boolean = true,
): BaseEntity() {

}
