package apex.cucumberframework.customlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.AbstractFindByBuilder;
import org.openqa.selenium.support.PageFactoryFinder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PageFactoryFinder(FindByCustom.FindByCustomBuilder.class)

public @interface FindByCustom {

    String HTMLAttribute();
    String HTMLValue();

    public static class FindByCustomBuilder extends AbstractFindByBuilder {
        public By buildIt(Object annotation, Field field) {
            FindByCustom findBy = (FindByCustom) annotation;
            return new ByHtmlAttribute(findBy.HTMLAttribute(),findBy.HTMLValue());
        }

    }

}