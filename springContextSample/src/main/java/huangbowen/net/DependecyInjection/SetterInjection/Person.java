package huangbowen.net.DependecyInjection.SetterInjection;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
