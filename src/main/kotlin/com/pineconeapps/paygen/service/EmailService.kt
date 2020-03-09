package com.pineconeapps.paygen.service

import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.Response.Companion.error
import com.pineconeapps.paygen.entity.Response.Companion.ok
import com.pineconeapps.paygen.utils.Constants
import com.pineconeapps.paygen.utils.PaygenException
import com.sendgrid.*
import java.io.IOException

object EmailService {
    @JvmStatic
    fun sendEmailNewUser(email: String?, message: String?): Response{
        val from = Email("no-reply@watchlist.com")
        val subject = "Account activation"
        val to = Email(email)
        val content = Content("text/html", message)
        val mail = Mail(from, subject, to, content)
        val sg = SendGrid(Constants.EMAIL_KEY)
        val request = Request()
        try {
            request.method = Method.POST
            request.endpoint = "mail/send"
            request.body = mail.build()
            val response = sg.api(request)
            println(response.statusCode)
            println(response.body)
            println(response.headers)
            return ok("Email sent")
        } catch (ex: IOException) {
        throw PaygenException("Email not sent")
        }
    }
}