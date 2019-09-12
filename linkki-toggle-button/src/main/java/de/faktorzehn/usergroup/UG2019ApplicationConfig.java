/*
 * Copyright Faktor Zehn AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.faktorzehn.usergroup;

import org.linkki.framework.state.ApplicationConfig;
import org.linkki.framework.ui.application.ApplicationFooter;
import org.linkki.framework.ui.application.ApplicationHeader;
import org.linkki.framework.ui.application.ApplicationLayout;
import org.linkki.framework.ui.application.ApplicationNavigator;
import org.linkki.framework.ui.application.menu.ApplicationMenuItemDefinition;
import org.linkki.util.Sequence;

import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;

/**
 * An {@link ApplicationConfig} using the default {@link ApplicationHeader
 * application header} and {@link ApplicationFooter application footer}.
 */
public class UG2019ApplicationConfig implements ApplicationConfig {

	private ApplicationNavigator navigator;

	public UG2019ApplicationConfig(SpringNavigator springNavigator) {
		this.navigator = new SpringApplicationNavigator(springNavigator);
	}

	@Override
	public String getApplicationName() {
		return "UG2019 Sample Application";
	}

	@Override
	public String getApplicationVersion() {
		return "0.0.1-SNAPSHOT";
	}

	@Override
	public String getApplicationDescription() {
		return "UG2019 Sample Application";

	}

	@Override
	public String getCopyright() {
		return "";
	}

	@Override
	public Sequence<ApplicationMenuItemDefinition> getMenuItemDefinitions() {
		return Sequence.empty();
	}

	@Override
	public ApplicationNavigator createApplicationNavigator(UI ui, ApplicationLayout applicationLayout) {
		return navigator;
	}

}
