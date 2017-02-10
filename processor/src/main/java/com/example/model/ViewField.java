package com.example.model;

import com.example.annotation.BindView;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;

/**
 * Created by zhouyou on 17/2/10.
 */
public class ViewField {

    private VariableElement variableElement;

    private int resId;

    public ViewField(Element element) {
        if (element.getKind() != ElementKind.FIELD) {
            throw new IllegalArgumentException("Only fields can be annotated");
        }
        variableElement = (VariableElement) element;
        BindView bindView = variableElement.getAnnotation(BindView.class);
        resId = bindView.value();

        if (resId < 0) {
            throw new IllegalArgumentException(
                    String.format("value() in %s for field %s is not valid !", BindView.class.getSimpleName(),
                            variableElement.getSimpleName()));
        }
    }

    public Name getFieldName() {
        return variableElement != null ? variableElement.getSimpleName() : null;
    }

    public int getResId() {
        return resId;
    }

}
