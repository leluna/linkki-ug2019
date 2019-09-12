package de.faktorzehn.usergroup.togglebutton.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;

import org.linkki.core.binding.descriptor.aspect.Aspect;
import org.linkki.core.binding.descriptor.aspect.LinkkiAspectDefinition;
import org.linkki.core.binding.descriptor.aspect.annotation.AspectDefinitionCreator;
import org.linkki.core.binding.descriptor.aspect.annotation.LinkkiAspect;
import org.linkki.core.binding.descriptor.property.annotation.LinkkiBoundProperty;
import org.linkki.core.binding.dispatcher.PropertyDispatcher;
import org.linkki.core.binding.uicreation.LinkkiComponent;
import org.linkki.core.binding.uicreation.LinkkiComponentDefinition;
import org.linkki.core.binding.wrapper.ComponentWrapper;
import org.linkki.core.ui.aspects.ValueAspectDefinition;
import org.linkki.core.uicreation.ComponentDefinitionCreator;
import org.linkki.core.uicreation.LinkkiPositioned;
import org.linkki.util.handler.Handler;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

import de.faktorzehn.usergroup.togglebutton.annotations.UIToggleButton.ToggleButtonAspectDefinitionCreator;
import de.faktorzehn.usergroup.togglebutton.annotations.UIToggleButton.ToggleButtonCreator;

@LinkkiAspect(ToggleButtonAspectDefinitionCreator.class)
@LinkkiComponent(ToggleButtonCreator.class)
@LinkkiBoundProperty(PmoPropertyOnlyBoundPropertyCreator.class)
@LinkkiPositioned
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UIToggleButton {

	@LinkkiPositioned.Position
	int position();

	VaadinIcons set();

	VaadinIcons unset();

	public class ToggleButtonCreator implements ComponentDefinitionCreator<UIToggleButton> {

		@Override
		public LinkkiComponentDefinition create(UIToggleButton annotation, AnnotatedElement annotatedElement) {
			return pmo -> new Button();
		}
	}

	public class ToggleButtonAspectDefinitionCreator implements AspectDefinitionCreator<UIToggleButton> {

		@Override
		public LinkkiAspectDefinition create(UIToggleButton annotation) {
			return new ToggleButtonAspectDefinition(annotation.set(), annotation.unset());
		}
	}

	public class ToggleButtonAspectDefinition implements LinkkiAspectDefinition {

		private final Resource trueIcon;
		private final Resource falseIcon;

		public ToggleButtonAspectDefinition(Resource trueIcon, Resource falseIcon) {
			this.trueIcon = trueIcon;
			this.falseIcon = falseIcon;
		}

		@Override
		public Handler createUiUpdater(PropertyDispatcher propertyDispatcher, ComponentWrapper componentWrapper) {
			Button button = (Button) componentWrapper.getComponent();
			return () -> {
				boolean set = propertyDispatcher.pull(Aspect.of(ValueAspectDefinition.NAME));
				Resource icon = set ? trueIcon : falseIcon;
				button.setIcon(icon);
			};
		}

		@Override
		public void initModelUpdate(PropertyDispatcher propertyDispatcher, ComponentWrapper componentWrapper,
				Handler modelChanged) {
			Button button = (Button) componentWrapper.getComponent();
			button.addClickListener(e -> {
				boolean currentValue = propertyDispatcher.pull(Aspect.of(ValueAspectDefinition.NAME));
				propertyDispatcher.push(Aspect.of(ValueAspectDefinition.NAME, !currentValue));
				modelChanged.apply();
			});
		}
	}
}
