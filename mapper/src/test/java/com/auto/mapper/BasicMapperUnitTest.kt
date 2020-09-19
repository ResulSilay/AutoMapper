package com.auto.mapper

import com.auto.mapper.data.model.UserModel
import com.auto.mapper.data.request.UserRequest
import org.junit.Test

import org.junit.Assert.*

class BasicMapperUnitTest {

    @Test
    fun modelToRequest() {
        val expectedDTO = UserRequest(id = 1, name = "Yunus Emre", address = "Turkey")
        val userModel = UserModel(id = 1, name = "Yunus Emre", password = "123", address = "Turkey", phone = "05350000000")
        val userDTO = AutoMapper.map<UserRequest>(userModel)

        assertEquals(expectedDTO, userDTO)
    }

    @Test
    fun collectionModelToRequest() {

        val userModelList = ArrayList<UserModel>()
        val expectedUserDTO = ArrayList<UserRequest>()

        for (index in 0..9) {
            userModelList.add(UserModel(id = index, name = "Yunus Emre", password = "123", address = "Turkey", phone = "0535000000${index}"))
            expectedUserDTO.add(UserRequest(id = index, name = "Yunus Emre", address = "Turkey"))
        }

        val userDTO = AutoMapper.map<List<UserRequest>>(userModelList)

        assertEquals(expectedUserDTO, userDTO)
    }
}