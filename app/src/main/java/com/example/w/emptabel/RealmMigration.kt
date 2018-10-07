package com.example.w.emptabel

import io.realm.DynamicRealm
import io.realm.RealmMigration

class RealmMigration : RealmMigration {

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        var oldVersion = oldVersion
        val schema = realm.schema

        //schema.get("MyBook");
        if (oldVersion == 0L) {
            schema.get("Customer")?.addField("id", Int::class.javaPrimitiveType)
            oldVersion++
        }

        if (oldVersion == 1L) {
            schema.get("Customer")?.addField("age", Int::class.javaPrimitiveType)
            oldVersion++
        }
    }
}