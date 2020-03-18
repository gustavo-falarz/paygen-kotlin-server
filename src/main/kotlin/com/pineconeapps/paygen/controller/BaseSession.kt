package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.utils.MessageHandler
import com.pineconeapps.paygen.utils.VerificationUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class BaseSession {
    @Autowired
    lateinit var messageHandler: MessageHandler

    @Autowired
    lateinit var verificationUtils: VerificationUtils

    fun error(code: String) = messageHandler.getMessage(code)

    fun message(code: String) = messageHandler.getMessage(code)

    fun <T> Optional<T>.throwIfDuplicate(msg: String) {
        verificationUtils.checkDuplicate(this, msg)
    }

    fun <T> Optional<T>.throwIfNull(msg: String) {
        verificationUtils.exists(this, msg)
    }
}
