package com.simple.jdk8apipractice.javalang.Cloneable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Simple
 * @Create 2021/7/2 14:14
 */

@AllArgsConstructor
@Data
public class ObjectClone implements Cloneable {
    private String name;
    private Integer id;



    @Override
    public ObjectClone clone() throws CloneNotSupportedException {
        return (ObjectClone) super.clone();
    }
}
