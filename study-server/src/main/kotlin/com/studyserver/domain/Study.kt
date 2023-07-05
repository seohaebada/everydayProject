package com.studyserver.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "study")
@Entity
class Study(
    @Id
    @GeneratedValue
    private var id: Long? = null,

    @Column(unique = true)
    private val path: String? = null,

    private val title: String? = null,

    private val shortDescription: String? = null,

    @Lob
    private val fullDescription: String? = null,

    @Lob
    private val image: String? = null,

    private val publishedDateTime: LocalDateTime? = null,

    private val closedDateTime: LocalDateTime? = null,

    private val recruitingUpdatedDateTime: LocalDateTime? = null,

    private val recruiting: Boolean = false,

    private val published: Boolean = false,

    private val closed: Boolean = false,

    private val useBanner: Boolean = false,

    private val memberCount: Int = 0,
) {

}