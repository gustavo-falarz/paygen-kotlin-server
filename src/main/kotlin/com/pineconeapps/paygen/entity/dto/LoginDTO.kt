package com.pineconeapps.paygen.entity.dto

import com.pineconeapps.paygen.entity.User


class LoginDTO {
    var providerId: String? = null
    var userId: String? = null
    var token: String? = null
    var status: User.Status = User.Status.ACTIVE
    var picture: String? = null
    var userName: String? = null
}