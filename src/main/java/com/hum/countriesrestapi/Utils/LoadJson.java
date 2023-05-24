package com.hum.countriesrestapi.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hum.countriesrestapi.model.Country;

@Component
public class LoadJson {
    public Map<String, Country> countries;
    public List<Country> countriesList = new ArrayList<>();
    private String flagsBaseUrl = "http://aedemirsen.bilgimeclisi.com/country_flags";
    
    public  List<Country> loadJson() { // JSON dosyasını okur ve verileri nesnelere dönüştürür
        File jsonFile = new File("assets/countries.json");

        try{
            HashMap<String, Country> result =
            new ObjectMapper().readValue(jsonFile, HashMap.class);//jsonFile
             //all country codes.
             Set<String> keySet =  result.keySet();
             for (Object id : keySet) {
                 Map<String, Object> m = (Map<String, Object>) result.get(id.toString());
                 String name = m.get("name").toString();
                 String nativeName = m.get("native").toString();
                 int phone;
                 try {
                     phone = Integer.parseInt(m.get("phone").toString());
                 } catch (NumberFormatException e) {
                     phone = -999;
                 }
                 String continent = m.get("continent").toString();
                 String capital = m.get("capital").toString();
                 String currency = m.get("currency").toString();
                 String languages = m.get("languages").toString();
                 String flagUrl = flagUrl(id.toString());
                 Country c = Country.builder().code(id.toString()).name(name).nativeName(nativeName)
                         .phone(phone).continent(continent).capital(capital).currency(currency)
                         .languages(languages).flag(flagUrl).build();
                countriesList.add(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return countriesList;
    } 

    private String flagUrl(String id){
        return flagsBaseUrl+"/"+id+".svg";
    }
}
