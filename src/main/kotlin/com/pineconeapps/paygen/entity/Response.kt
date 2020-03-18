package com.pineconeapps.paygen.entity


class Response(val status: Boolean, val message: String) {

    companion object {
        fun error(message: String): Response {
            return Response(status = false, message = message)
        }

        fun ok(message: String): Response {
            return Response(status = true, message = message)
        }
    }
}
