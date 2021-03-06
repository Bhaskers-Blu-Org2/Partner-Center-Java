// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license. See the LICENSE file in the project root for full license information.

package com.microsoft.store.partnercenter.countryvalidationrules;

import java.text.MessageFormat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.countryvalidationrules.CountryValidationRules;
import com.microsoft.store.partnercenter.utils.ParameterValidator;

/**
 * The country validation rules operations implementation.
 */
public class CountryValidationRulesOperations 
	extends BasePartnerComponentString
	implements ICountryValidationRules 
{

	/**
	 * Initializes a new instance of the CountryValidationRulesOperations class.
	 * @param rootPartnerOperations The root partner operations instance
	 * @param country The country
	 */
	protected CountryValidationRulesOperations(IPartner rootPartnerOperations, String country)
	{
		super(rootPartnerOperations, country);
		ParameterValidator.isValidCountryCode(country);
	}

	/**
	 * Gets the market specific validation data by country.
	 */
	@Override
	public CountryValidationRules get() 
	{
		return this.getPartner().getServiceClient().get(
			this.getPartner(),
			new TypeReference<CountryValidationRules>(){}, 
			MessageFormat.format(
				PartnerService.getInstance().getConfiguration().getApis().get("GetCountryValidationRulesByCountry").getPath(),
				this.getContext()));
	}
}