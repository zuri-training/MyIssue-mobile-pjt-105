package com.example.pjt105.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pjt105.db.entities.LoginEntity

@Dao
interface LoginDao {
    @Query("SELECT * FROM login")
    fun selectAllLogin() : LiveData<List<LoginEntity>>

    @Query("SELECT * FROM login where email=:email")
    fun findLoginEntityByEmail(email: String) : LoginEntity?

    @Insert
    fun insertLogin(loginEntity: LoginEntity)

    @Delete
    fun deleteLogin(loginEntity: LoginEntity)

    @Update
    fun updateLogin(loginEntity: LoginEntity)

}