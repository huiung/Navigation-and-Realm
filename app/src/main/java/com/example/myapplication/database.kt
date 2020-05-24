package com.example.myapplication

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import java.text.FieldPosition

open class exdata : RealmObject() {

    lateinit var name: String
    lateinit var phone: String
    lateinit var email: String

    override fun toString(): String {
        return "이름:"+name+'\n'+"전화번호:"+phone+'\n'+"이메일:"+email+'\n'
    }

}

object RealmManager {

    val realm = Realm.getDefaultInstance()

    fun find(name: String): exdata? {
        return realm.where(exdata::class.java).equalTo("name", name).findFirst()
    }

    fun findAll(): List<exdata> {
        return realm.where(exdata::class.java).findAll()
    }

    fun create(curdata: exdata) {
        realm.beginTransaction()

        val data = realm.createObject(exdata::class.java)
        data.name = curdata.name
        data.phone = curdata.phone
        data.email = curdata.email

        realm.commitTransaction()
    }

    fun update(name: String, curdata: exdata) {
        realm.beginTransaction()
        val data = find(name)
        data?.name = curdata.name
        data?.phone = curdata.phone
        data?.email = curdata.email

        realm.commitTransaction()
    }

    fun deleteByName(name: String) {
        realm.beginTransaction()
        val data = realm.where(exdata::class.java).equalTo("name",name).findAll()
        data.deleteAllFromRealm()
        realm.commitTransaction()
    }
}