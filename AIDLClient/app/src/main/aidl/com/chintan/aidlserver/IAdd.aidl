// IAdd.aidl
package com.chintan.aidlserver;
import com.chintan.aidlserver.Person;
// Declare any non-default types here with import statements

interface IAdd {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int addNumbers(int num1, int num2);//2 argument method to add
    List<String> getStringList();
    List<Person> getPersonList();
    void placeCall(String number);
}
