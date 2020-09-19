package com.auto.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AutoMapper {

    companion object {

        inline fun <reified T> getType(): Type = object : TypeToken<T>() {}.type

        /**
         * @param input input model
         * @param output target model
         * @return target model
         */

        fun <T, K> map(input: T, output: Class<K>): K {
            val json = Gson().toJson(input)
            return Gson().fromJson(json, output)
        }

        inline fun <reified K> map(input: Any): K {
            val json = Gson().toJson(input)
            val type = getType<K>()
            return Gson().fromJson(json, type)
        }

        fun <T> toJson(model: T): String? {
            return Gson().toJson(model)
        }
    }
}