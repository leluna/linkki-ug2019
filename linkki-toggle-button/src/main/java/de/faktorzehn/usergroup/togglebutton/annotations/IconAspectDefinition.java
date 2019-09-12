package de.faktorzehn.usergroup.togglebutton.annotations;

import java.util.function.Consumer;

import org.linkki.core.binding.descriptor.aspect.Aspect;
import org.linkki.core.binding.descriptor.aspect.base.ModelToUiAspectDefinition;
import org.linkki.core.binding.wrapper.ComponentWrapper;

import com.vaadin.server.Resource;
import com.vaadin.ui.Component;

public class IconAspectDefinition extends ModelToUiAspectDefinition<Resource> {

	@Override
	public Aspect<Resource> createAspect() {
		return Aspect.of("icon");
	}

	@Override
	public Consumer<Resource> createComponentValueSetter(ComponentWrapper componentWrapper) {
		return icon -> ((Component) componentWrapper.getComponent()).setIcon(icon);
	}
}