package com.example.devpartners.sidebucks.event

import com.example.devpartners.sidebucks.enum.UserType

class LoginAsEvent {
    var type : UserType

    constructor(data : UserType) {
        this.type = data
    }
}