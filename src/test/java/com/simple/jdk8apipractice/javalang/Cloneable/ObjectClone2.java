package com.simple.jdk8apipractice.javalang.Cloneable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Simple
 * @Create 2021/10/12 18:27
 */
@AllArgsConstructor
@Data
class ObjectClone2 implements Cloneable{
    private String name;
    private Integer id;
    private ObjectClone objectClone;



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

