package app.model;

public class User {

    private String name;
    private int age;
    private City city;

    public User(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((User)obj).getName());
    }

    public int getAge() {
        return age;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name;
    }
}
