package com.simple.jdk8apipractice.javalang.Object;

/**
 * @Author Simple
 * @Create 2021/10/12 18:27
 */
class ObjectClone2 implements Cloneable{
    private String name;
    private Integer id;
    private ObjectClone objectClone;

    public ObjectClone2(String name, Integer id, ObjectClone objectClone) {
        this.name = name;
        this.id = id;
        this.objectClone = objectClone;
    }

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

    public ObjectClone getObjectClone() {
        return objectClone;
    }

    public void setObjectClone(ObjectClone objectClone) {
        this.objectClone = objectClone;
    }

    /**
     * 深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public ObjectClone2 clone() throws CloneNotSupportedException {
        ObjectClone2 class2 = (ObjectClone2) super.clone();
        class2.objectClone = objectClone.clone();
        return class2;
    }

}

