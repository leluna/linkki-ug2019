package de.faktorzehn.usergroup.togglebutton;

import java.util.Arrays;
import java.util.List;

import org.linkki.core.defaults.columnbased.pmo.ContainerPmo;

public class ContactTablePmo implements ContainerPmo<ContactRowPmo> {

	private List<ContactRowPmo> rows;

	public ContactTablePmo() {
		rows = Arrays.asList(new ContactRowPmo("Address", "Awesome Drive 1", true),
				new ContactRowPmo("Email", "iamawesome@faktorzehn.de", true),
				new ContactRowPmo("Email", "iamawesome@private.com", false));
	}

	@Override
	public List<ContactRowPmo> getItems() {
		return rows;
	}

	@Override
	public int getPageLength() {
		return 3;
	}
}
