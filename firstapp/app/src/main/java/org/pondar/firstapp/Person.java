package org.pondar.firstapp;

public class Person
{
    public int age;
    public String name;


    public Person(){}

    public Person(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    public String toString(Person p)
    {
        if (isOld(p) == true)
        {
            return p.name + " " + p.age + "Is Old";
        }
        else if(isOld(p) == false)
        {
            return p.name + " " + p.age + " " + "Is Young";
        }

        return p.name + " " + p.age;
    }

    public Boolean isOld(Person p)
    {
        if (p.age > 50)
        {
            return true;
        }
        else if(p.age <= 50)
        {
            return false;
        }

        return null;
    }
}
