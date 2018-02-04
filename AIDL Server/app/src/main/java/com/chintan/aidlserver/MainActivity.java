package com.chintan.aidlserver;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<String> country;
    private static List<Person> person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dexter.initialize(this);
        Dexter.checkPermission(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }, Manifest.permission.CALL_PHONE);
    }

    public static List<String> getList() {
        country = new ArrayList<>();
        country.add("India");
        country.add("Bhutan");
        country.add("Nepal");
        country.add("USA");
        country.add("Canada");
        country.add("China");
        return country;
    }

    public static List<Person> getPersons() {
        person = new ArrayList<>();
        person.add(new Person("A", 10));
        person.add(new Person("B", 20));
        person.add(new Person("C", 30));
        person.add(new Person("D", 40));
        person.add(new Person("E", 50));
        person.add(new Person("F", 60));
        return person;
    }

    public void placeCall(String number) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_FROM_BACKGROUND);
        startActivity(intent);
    }
}
