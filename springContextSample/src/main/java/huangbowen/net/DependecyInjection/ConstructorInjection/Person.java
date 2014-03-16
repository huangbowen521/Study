package huangbowen.net.DependecyInjection.ConstructorInjection;

import java.beans.ConstructorProperties;

public class Person {
    private String name;
    private int age;

    @ConstructorProperties({"name", "age"})
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
