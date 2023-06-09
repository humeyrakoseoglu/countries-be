package com.hum.countriesrestapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hum.countriesrestapi.model.Country;
import com.hum.countriesrestapi.service.CountryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/countries") // controller /countries kök dizini altında HTTP isteklerine yanıt verir
public class CountryController { //bu sınıf HTTP isteklerini işleyerek CountryService bileşeninin yöntemlerini çağırır ve sonuçları HTTP yanıtı olarak döndürür
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/one-time-insert") //tüm verileri insert eder
    public void oneTimeInsert() {
        if (countryService.getAllCountries().size() == 0) {
         countryService.oneTimeInsert();
        }
    }

    @GetMapping("/getCountries")  //tüm ülkeleri döndürür
    public List<Country>  getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/code/{code}") //belirli bir ülkenin koduna (code) göre veritabanından alır
    public Country getCountryByCode(@PathVariable String code) { //pathVariable  HTTP isteğinin yoluna erişim sağlar
        return countryService.getCountryByCode(code);
    }

    @DeleteMapping("/code/{code}") //belirli bir ülkenin koduna (code) göre veritabanından siler
    public void deleteCountryById(@PathVariable String code) { //pathVariable  HTTP isteğinin yoluna erişim sağlar
        countryService.deleteCountryById(code);
    }

  @GetMapping("/name/{name}") //belirli bir ülkenin adına (name) göre veritabanından alır
    public Country getCountryByName(@PathVariable String name) { //pathVariable  HTTP isteğinin yoluna erişim sağlar
        return countryService.getCountryByName(name);
  }

  @GetMapping("/phone/{phoneCode}") // phone code'una göre veritabanından ilgili ülkeleri alır
  public List<Country> getCountryByPhoneCode(@PathVariable int phoneCode) { //pathVariable  HTTP isteğinin yoluna erişim sağlar
      return countryService.getCountryByPhoneCode(phoneCode);
    }

    @PostMapping("/add") // veritabanına ülke ekler
    Country insertCountry(@RequestBody Country newCountry) {
      return countryService.insertCountry(newCountry);
    }
   
  @GetMapping("/sorted/{order}")
  public List<Country> orderCountriesByPhoneCode(@PathVariable String order) {//girilen parametreyi dikkate alarak ülkeleri phone code'a göre sıralar
      return countryService.orderCountriesByPhoneCode(order);
  }

   @GetMapping("/filter") //@RequestParam parametresini isteğe bağlı yapmak istenirse required özelliğini false yapılır
   public List<Country> getCountriesByProperties(@RequestParam(required = false) String currency,
                                                  @RequestParam(required = false) Integer phone,
                                                  @RequestParam(required = false) String continent) {//girilen parametre değerlerine uygun ülkeleri döndürür
       return countryService.getCountriesByProperties(currency, phone, continent);
   }

}