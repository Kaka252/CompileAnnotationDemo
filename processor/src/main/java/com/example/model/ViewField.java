package com.example.model;

import com.anno.BindView;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/**
 * Created by zhouyou on 17/2/10.
 */
public class ViewField {

    private VariableElement fieldElement;

    private int resId;

    public ViewField(Element element) {
        if (element.getKind() != ElementKind.FIELD) {
            throw new IllegalArgumentException("Only fields can be annotated");
        }
        fieldElement = (VariableElement) element;
        BindView bindView = fieldElement.getAnnotation(BindView.class);
        resId = bindView.value();

        if (resId < 0) {
            throw new IllegalArgumentException(
                    String.format("value() in %s for field %s is not valid !", BindView.class.getSimpleName(),
                            fieldElement.getSimpleName()));
        }
    }

    public Name getFieldName() {
        return fieldElement != null ? fieldElement.getSimpleName() : null;
    }

    public int getResId() {
        return resId;
    }

    public TypeMirror getFieldType() {
        return fieldElement.asType();
    }

}
