package com.example;

import com.example.annotation.HelloWorldAnnotation;
import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 * http://brucezz.itscoder.com/use-apt-in-android
 */
@SupportedAnnotationTypes("com.example.annotation.HelloWorldAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@AutoService(Processor.class)
public class HelloWorldProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {






        StringBuilder sb = new StringBuilder();
        sb.append("package com.example.generated;\n\n");
        sb.append("public class GeneratedClass {\n\n");
        sb.append("\tpublic String getMessage() {\n");
        sb.append("\t\treturn \"");

        for (Element element : roundEnvironment.getElementsAnnotatedWith(HelloWorldAnnotation.class)) {
            String objType = element.getSimpleName().toString();
            sb.append(objType).append(" says hello!\\n");
        }
        sb.append("\";\n");
        sb.append("\t}\n");
        sb.append("}\n");

        try {
            JavaFileObject source = processingEnv.getFiler().createSourceFile("com.example.generated.GeneratedClass");
            Writer writer = source.openWriter();
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
