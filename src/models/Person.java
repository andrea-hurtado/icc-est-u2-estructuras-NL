package models;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Persona [name= " + name + ", age= " + age + "]";
    }

    @Override
    public int compareTo(Person otra) {
        // this.age > otra.getAge();
        int resulComp = Integer.compare(this.age, otra.getAge());
        if (resulComp != 0) {
            return resulComp;
        }
        // compara otro parametro
        return this.name.compareTo(otra.getName());
        
    }  
     @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
      

}
