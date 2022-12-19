package com.example.androidproject.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidproject.data.auth.AuthRepositoryImpl
import com.example.androidproject.data.items.ItemsRepositoryImpl
import com.example.androidproject.data.sharedpref.SharedPreferenceHelper
import com.example.androidproject.domain.auth.AuthRepository
import com.example.androidproject.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(

        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository


    @Binds
    abstract fun bindAuthRepository(

        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

companion object{
    private const val  SP_KEY ="SP_KEY"

    @Provides

    fun provideSharedPreferences(@ApplicationContext context:Context):SharedPreferenceHelper{

        return  SharedPreferenceHelper(context.getSharedPreferences(SP_KEY,MODE_PRIVATE))



    }



}

}