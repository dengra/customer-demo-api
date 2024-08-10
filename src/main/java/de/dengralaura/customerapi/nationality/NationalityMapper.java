package de.dengralaura.customerapi.nationality;

import com.ibm.icu.text.LocaleDisplayNames;
import com.ibm.icu.util.ULocale;

public class NationalityMapper {
    public static String getNationality(String countryCode) {
        LocaleDisplayNames names = LocaleDisplayNames.getInstance(ULocale.GERMANY);
        return names.languageDisplayName(countryCode);
    }
}
