package com.example.appenglish.models;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Model {
    public CollectionReference collection;
    public DocumentReference document;

    public Query query;

    public String id;

    public CollectionReference collection() {
        if (collection == null) {
            collection = FirebaseFirestore.getInstance().collection(getTableName());
        }
        return collection;
    }

    public DocumentReference document() {
        if (document == null) {
            document = collection().document();
            id = document.getId();
        } else if (id != null) {
            document = collection().document(id);
        }
        return document;
    }

    public String id() {
        if (id == null) {
            id = document().getId();
        }
        return id;
    }

    public String getTableName() {
        return "";
    }

    public void save() {
        document().set(record());
    }

    public Query query() {
        if (query == null) {
            query = collection().whereNotEqualTo("id", -1);
        }
        return query;
    }

    public Model where(String field, String operation, Object value) {

        switch (operation) {
            case "=":
                query().whereEqualTo(field, value);
                break;
            case ">=":
                query().whereGreaterThanOrEqualTo(field, value);
                break;
            case ">":
                query().whereGreaterThan(field, value);
                break;
            case "<=":
                query().whereLessThanOrEqualTo(field, value);
                break;
            case "<":
                query().whereLessThan(field, value);
                break;
            case "!=":
                query().whereNotEqualTo(field, value);
        }
        return this;
    }

    public void get() {
        query().get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("model", document.getId() + " => " + document.getData());
                    }
                } else {
                    Log.d("model", "Error getting documents: ", task.getException());
                }
            }
        });
    }

    public Model find(String id) {

        try {
            Model model = this.getClass().newInstance();
            model.collection()
                    .document(id).get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot result = task.getResult();
                                model.set(result);
                            } else {
                                Log.d("model", "fail to get data");
                            }
                        }
                    });

            return model;

        } catch (Exception e) {
            Log.d("model", "create new instance fail");
        }

        return new Model();
    }

    public Model set(DocumentSnapshot doc) {

        Field[] fields = this.getClass().getFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                field.set(this, doc.get(field.getName()));
            } catch (Exception e) {

                Log.d("model", e.getMessage());
            }

        }

        return this;
    }

    public Map<String, Object> record() {
        Map<String, Object> record = new HashMap<>();

        Field[] fields = this.getClass().getFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            if (
                    fields[i].getName() == "collection" ||
                            fields[i].getName() == "document" ||
                            fields[i].getName() == "query"
            ) {
                continue;
            }

            try {
                record.put(fields[i].getName(), fields[i].get(this));
            } catch (Exception e) {
                Log.d("model", e.getMessage());
            }
        }

        return record;
    }
}
