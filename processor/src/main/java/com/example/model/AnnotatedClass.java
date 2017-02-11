package com.example.model;

import com.example.utils.TypeUtil;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;
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

    public JavaFile generateFinder() {
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("bind");
        methodBuilder.addModifiers(Modifier.PUBLIC);
        methodBuilder.addAnnotation(Override.class);
        methodBuilder.addParameter(TypeName.get(classElement.asType()), "subscribe");
        methodBuilder.addParameter(TypeName.OBJECT, "source");
        methodBuilder.addParameter(TypeUtil.PROVIDER, "provider");

        for (ViewField field : fields) {
            methodBuilder.addStatement("subscribe.$N = ($T)(provider.findView(source, $L))",
                    field.getFieldName(),
                    ClassName.get(field.getFieldType()),
                    field.getResId());
        }
        if (methods.size() > 0) {
            methodBuilder.addStatement("$T listener", TypeUtil.ANDROID_ON_CLICK_LISTENER);
        }
//        for (OnClickMethod method : methods) {
//            TypeSpec listener = TypeSpec.anonymousClassBuilder("")
//
//            listener.build();
//        }

        TypeSpec findClass = TypeSpec.classBuilder(classElement.getSimpleName() + "$$Finder")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.FINDER, TypeName.get(classElement.asType())))
                .addMethod(methodBuilder.build())
                .build();
        String packageName = elementUtils.getPackageOf(classElement).getQualifiedName().toString();
        return JavaFile.builder(packageName, findClass).build();
    }

    public String getFullClassName() {
        return classElement.getQualifiedName().toString();
    }

    public void addField(ViewField field) {
        fields.add(field);
    }

}
