package nl.firepy.basicwebapp.model;

import nl.firepy.basicwebapp.model.interfaces.JsonConvertible;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.Objects;

public class User implements JsonConvertible {

    public static final String FIRST_NAME_TAG = "first_name";
    public static final String SURNAME_TAG = "surname";
    public static final String AGE_TAG = "age";

    private String firstName;
    private String surname;
    private int age;

    public User(String firstName, String surname, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public User(JsonObject object) {
        System.out.println(object.toString());
        this.firstName = object.getString(FIRST_NAME_TAG);
        this.surname = object.getString(SURNAME_TAG);
        this.age = Integer.parseInt(object.getString(AGE_TAG));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, age);
    }

    @Override
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add(FIRST_NAME_TAG, firstName)
                .add(SURNAME_TAG, surname)
                .add(AGE_TAG, ""+ age)
                .build();
    }
}
