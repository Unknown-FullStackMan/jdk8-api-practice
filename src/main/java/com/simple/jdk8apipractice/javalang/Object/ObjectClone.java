package com.simple.jdk8apipractice.javalang.Object;

/**
 * @Author Simple
 * @Create 2021/7/2 14:14
 */
public class ObjectClone implements Cloneable {
    private String name;
    private Integer id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public ObjectClone clone() throws CloneNotSupportedException {
        return (ObjectClone) super.clone();

    }
}
