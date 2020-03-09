package com.pineconeapps.paygen.entity.dto

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

class AuthDTO {
    var email: @NotNull String? = null
    var password: @NotNull @Min(6) String? = null

}