package com.pineconeapps.paygen.utils

import java.util.*

object StringUtils {
    fun generateRandomCode(): String {
        val alphabet = "abcdefghijklmnopqrstuvwxyz123456789"
        val N = alphabet.length
        val result = StringBuilder()
        val r = Random()
        for (i in 0..5) {
            result.append(alphabet[r.nextInt(N)])
        }
        return result.toString()
    }
}