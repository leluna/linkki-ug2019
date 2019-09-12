package de.faktorzehn.usergroup.togglebutton.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.linkki.core.binding.descriptor.property.BoundProperty;
import org.linkki.core.binding.descriptor.property.annotation.BoundPropertyCreator;

public class PmoPropertyOnlyBoundPropertyCreator implements BoundPropertyCreator<Annotation> {

	@Override
	public BoundProperty createBoundProperty(Annotation annotation, AnnotatedElement annotatedElement) {
		return BoundProperty.of((Method) annotatedElement);
	}

}
