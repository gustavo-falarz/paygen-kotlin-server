package com.pineconeapps.paygen.entity.dto

class ImagesDTO {
    var banner: String = ""
    var logo: String = ""

    constructor() {}

    constructor(banner: String, logo: String) {
        this.banner = banner
        this.logo = logo
    }
}
