package com.pineconeapps.paygen.utils

import org.springframework.stereotype.Component
import java.util.*

@Component
class VerificationUtils {

    fun <T> exists(optional: Optional<T>, msg: String) {
        if (!optional.isPresent) {
            throw PaygenException(msg)
        }
    }

    fun <T> checkDuplicate(optional: Optional<T>, msg: String) {
        if (optional.isPresent) {
            throw PaygenException(msg)
        }
    }


}
