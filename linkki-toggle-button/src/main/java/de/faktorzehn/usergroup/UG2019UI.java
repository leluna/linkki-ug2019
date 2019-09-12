package de.faktorzehn.usergroup;

import org.linkki.framework.ui.application.LinkkiUi;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringNavigator;

@Theme("ug2019")
@Widgetset("com.vaadin.v7.Vaadin7WidgetSet")
@SpringUI
@SpringViewDisplay
public class UG2019UI extends LinkkiUi implements ViewDisplay {

	private static final long serialVersionUID = 1L;

	@Autowired
	public UG2019UI(SpringNavigator springNavigator) {
		super(new UG2019ApplicationConfig(springNavigator));
	}

	@Override
	protected void init(VaadinRequest request) {
		super.init(request);
	}

	@Override
	public void showView(View view) {
		getApplicationLayout().showView(view);
	}

}
