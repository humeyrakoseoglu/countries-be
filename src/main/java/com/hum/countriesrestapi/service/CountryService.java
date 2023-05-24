package com.hum.countriesrestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hum.countriesrestapi.Utils.LoadJson;
import com.hum.countriesrestapi.model.Country;
import com.hum.countriesrestapi.repository.CountryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


@Service //bir sınıfın  iş mantığını içeren bir servis sınıfı olduğunu belirtir 
public class CountryService { 
    /*
     * Bu sınıf country verilerinin bir JSON dosyasından yüklenmesi, ülkelerin veritabanına eklenmesi ve çeşitli koşullara göre ülke verilerinin alınmasını sağlar
     */

    @Autowired
    private final EntityManager entityManager; // JPA ile çalışan uygulamalarda veritabanı işlemlerini yönetir

    @Autowired
    private CountryRepository countryRepository; // veritabanı işlemlerine erişmek için CountryRepository kullanılır

    @Autowired
    private LoadJson loadJson; // file

    public CountryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //@Transactional // işlemin tüm adımlarını tek bir işlem olarak işaretler
    public void oneTimeInsert() { //tüm verileri insert eder
            countryRepository.saveAll( loadJson.loadJson());//yoksa verileri jsondan veritabanına yükle);
    }
    
    public Country getCountryByCode(String id) { //girilen ülke koduna sahip ülkeleri döndürür
        Optional<Country> country = countryRepository.findById(id);
        return country.orElse(null);
    }

    public List<Country> getAllCountries() { //tüm ülkeleri döndürür
        return countryRepository.findAll();
    }

    public void deleteCountryById(String id) { //girilen ülke koduna sahip ülkeyi siler
        countryRepository.deleteById(id);
    }

    public Country getCountryByName(String name)  {//girilen isme sahip ülkeyi döndürür
        return countryRepository.getCountryByName(name);
    }

    public Country insertCountry(Country newCountry)  {//girilen isme sahip ülkeyi döndürür
        return countryRepository.save(newCountry);
    }

    public List<Country> getCountryByPhoneCode(int phoneCode) { //girilen telefon koduna sahip ülkeleri döndürür
       return countryRepository.getByPhone(phoneCode);
    }
 
    public List<Country> orderCountriesByPhoneCode(String order) {//girilen parametreyi dikkate alarak ülkeleri phone code'a göre sıralar
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = criteriaBuilder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        Order orderClause = null;
        if ("asc".equalsIgnoreCase(order)) {//artan
            orderClause = criteriaBuilder.asc(root.get("phone"));
        } else if ("dsc".equalsIgnoreCase(order)) {
            orderClause = criteriaBuilder.desc(root.get("phone"));
        } else {
            throw new IllegalArgumentException("order parametresi 'asc' veya 'desc' olmalidir.");
        }
        query = query.orderBy(orderClause);
        List<Country> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }


    public List<Country> getCountriesByProperties(String currency, int phoneCode, String continent) {//girilen parametre değerlerine uygun ülkeleri döndürür
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = criteriaBuilder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        List<Predicate> predicateList = new ArrayList<>();
        //null olup olmadıklarına bağlı olarak sorguda kullanılacak özellikler
        if (continent != null) {
            predicateList.add(criteriaBuilder.equal(root.get("continent"), continent));
        }
        if (currency != null) {
            predicateList.add(criteriaBuilder.equal(root.get("currency"), currency));
        }
        if (phoneCode != 0) {
            predicateList.add(criteriaBuilder.equal(root.get("phone"), phoneCode));
        }
        query.select(root).where(predicateList.toArray(new Predicate[]{}));
        List<Country> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }

}

/* JPA Repository kullanmadan Criteria API ile olsaydı

        public Country getCountryByName(String name)  {//girilen isme sahip ülkeyi döndürür
                //Criteria API’si ile SQL’de kullandığımız =, <, >, <=, >= ifadeleri, bunun yanında or, and, like bağlama işlemleri gerçekleştiriliyor.
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);//varlıklarını sorgulamak için bir CriteriaQuery nesnesi oluşturur.sorgulanacak varlık türü
                Root<Country> countryRoot = criteriaQuery.from(Country.class); // sorgunun başlangıç noktasını tanımla.sorgu yüklemlerini, seçimi ve sıralama yan tümcelerini tanımlamak için kullanılabilecek bir nesne döndürür.
                CriteriaQuery<Country> queryByName = criteriaQuery
                        .select(countryRoot)
                        .where(criteriaBuilder.equal(countryRoot.get("name"), name));
                        Country singleResult = entityManager.createQuery(queryByName).getSingleResult(); ////EntityManager'ı kullanarak sorguyu yürütür ve tek bir sonuç bekler 
                return singleResult;  
        }
        

         public List<Country> getCountryByPhoneCode(int phoneCode) { //girilen telefon koduna sahip ülkeleri döndürür
             CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
             CriteriaQuery<Country> query = criteriaBuilder.createQuery(Country.class);
             Root<Country> root = query.from(Country.class);
             query.where(criteriaBuilder.in(root.get("phone")).value(phoneCode));
             List<Country> resultList = entityManager.createQuery(query).getResultList();
             return resultList;
         }

*/