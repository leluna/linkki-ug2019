package de.faktorzehn.usergroup.togglebutton.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.linkki.core.binding.descriptor.aspect.LinkkiAspectDefinition;
import org.linkki.core.binding.descriptor.aspect.annotation.AspectDefinitionCreator;
import org.linkki.core.binding.descriptor.aspect.annotation.LinkkiAspect;

import de.faktorzehn.usergroup.togglebutton.annotations.BindIcon.IconApsectDefinitionCreator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@LinkkiAspect(IconApsectDefinitionCreator.class)
public @interface BindIcon {

	public class IconApsectDefinitionCreator implements AspectDefinitionCreator<BindIcon> {
		@Override
		public LinkkiAspectDefinition create(BindIcon annotation) {
			return new IconAspectDefinition();
		}
	}
}
