package de.faktorzehn.usergroup.togglebutton;

import org.linkki.core.ui.element.annotation.UILabel;

import com.vaadin.icons.VaadinIcons;

import de.faktorzehn.usergroup.togglebutton.annotations.UIToggleButton;

public class ContactRowPmo {

	private String kind;
	private String details;
	private boolean primary;

	public ContactRowPmo(String kind, String details, boolean primary) {
		this.kind = kind;
		this.details = details;
		this.primary = primary;
	}

	@UILabel(position = 10, label = "Kind")
	public String getKind() {
		return kind;
	}

	@UILabel(position = 20, label = "Details")
	public String getDetails() {
		return details;
	}

	@UIToggleButton(position = 30, set = VaadinIcons.FLAG, unset = VaadinIcons.FLAG_O)
	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
}
