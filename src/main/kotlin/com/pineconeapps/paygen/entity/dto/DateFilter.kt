package com.pineconeapps.paygen.entity.dto

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

class DateFilter {
    @JvmField
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    var startDate: Date? = null

    @JvmField
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    var endDate: Date? = null

    constructor() {}
    constructor(startDate: Date?, endDate: Date?) {
        this.startDate = startDate
        this.endDate = endDate
    }
}