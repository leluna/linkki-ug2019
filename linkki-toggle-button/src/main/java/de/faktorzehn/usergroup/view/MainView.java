package de.faktorzehn.usergroup.view;

import org.linkki.core.binding.BindingContext;
import org.linkki.core.ui.creation.table.PmoBasedTableFactory;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;

import de.faktorzehn.usergroup.togglebutton.ContactTablePmo;

@SpringView(name = MainView.NAME)
public class MainView extends CssLayout implements View {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "";

	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new PmoBasedTableFactory(new ContactTablePmo(), new BindingContext()).createTable());

		addStyleName("flex-view");
		setHeight("100%");
	}

}