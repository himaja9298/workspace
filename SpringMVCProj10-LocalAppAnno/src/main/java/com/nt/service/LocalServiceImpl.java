package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("localeService")
public class LocalServiceImpl implements ILocaleService {
	Locale locales[] = null;
	Set<String> countries = null;
	Set<String>languages=null;
    
	@Override
	public Set<String> getAllCountries() {
		countries = new TreeSet();
		locales=Locale.getAvailableLocales();
		for (Locale l : locales) {
			if (!l.getDisplayCountry().equals(""))
				countries.add(l.getDisplayCountry());
		}
		return countries;

	}

	@Override
	public Set<String> getAllCountriesLanguages() {
		locales=Locale.getAvailableLocales();
		languages = new TreeSet();
		for (Locale l : locales) {
			languages.add(l.getDisplayLanguage());
		}
		return languages;
	}

}
