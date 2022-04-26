package com.simple.jdk8apipractice.javalang.Cloneable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Simple
 * @Create 2021/10/12 18:27
 */
@AllArgsConstructor
@Data
class ObjectClone3 implements Cloneable{
    private String name;
    private Integer id;
    private ObjectClone objectClone;


    /**
     * 深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public ObjectClone3 clone() throws CloneNotSupportedException {
        ObjectClone3 class3 = (ObjectClone3) super.clone();
        return class3;
    }

}

