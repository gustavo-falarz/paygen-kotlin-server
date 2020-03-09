package com.pineconeapps.paygen.entity.dto

class ImagesDTO {
    var banner: String? = null
    var logo: String? = null

    constructor() {}

    constructor(banner: String?, logo: String?) {
        this.banner = banner
        this.logo = logo
    }
}