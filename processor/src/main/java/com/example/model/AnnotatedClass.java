package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by zhouyou on 17/2/10.
 */

public class AnnotatedClass {

    public TypeElement classElement;
    public List<ViewField> fields;
    public List<OnClickMethod> methods;
    public Elements elementUtils;

    public AnnotatedClass(TypeElement classElement, Elements elementUtils) {
        this.classElement = classElement;
        this.fields = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.elementUtils = elementUtils;
    }


}
