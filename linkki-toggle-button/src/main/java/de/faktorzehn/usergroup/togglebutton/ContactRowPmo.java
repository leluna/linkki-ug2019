package de.faktorzehn.usergroup.togglebutton;

import org.linkki.core.ui.element.annotation.UICheckBox;
import org.linkki.core.ui.element.annotation.UILabel;

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

	@UICheckBox(position = 30, caption = "", label = "Primary")
	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

}
