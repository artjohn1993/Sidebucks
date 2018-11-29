package com.example.devpartners.sidebucks.enum

enum class UserType {
    SERVICE_PROVIDER,
    CUSTOMER
}

enum class OpenGallery {
    CLEARANCE { override fun getValue() = 1003 },
    ID { override fun getValue() = 1002 };

    abstract fun getValue() : Int
}