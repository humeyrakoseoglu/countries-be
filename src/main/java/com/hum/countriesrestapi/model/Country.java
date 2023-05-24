package com.hum.countriesrestapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data // @ToString, @EqualsAndHashCode, @Getter ve @Setter işlevlerini birleştirir.
@Builder  //sınıfa Builder Pattern uygulamayı saglar
@NoArgsConstructor
@AllArgsConstructor
@Entity //Sınıfları entity olarak framework e tanıtır
@Table(name = "country") //bir varlığın veritabanında hangi tabloya karşılık geldiğini belirtir
public class Country {

  @Id //bir entity sınıfının anahtar alanını belirtir
  @Column(name = "id") //bir sınıf alanının veritabanındaki bir sütunla eşleştiğini belirtir
  private String code;
  private String name;
  @Column(name="native_name")
  @JsonProperty("native")//Alanlarımızın json içerisinde hangi isimle gözükeceğini belirledim
  private String nativeName; 
  private int phone;
  private String continent; 
  private String capital;
  private String currency;
  private String languages;
  private String flag;
}