package com.epicode.prenotazioni.configurations;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.prenotazioni.models.Address;
import com.github.javafaker.Faker;

@Configuration
public class AddressConfiguration {

	Faker faker = Faker.instance(new Locale("it-IT"));
	
	@Bean
	@Scope("prototype")
	public Address newAddress() {
		Address address = new Address();
		address.setCity(faker.address().cityName());
		address.setAddress(faker.address().streetAddress());
		address.setProvince(faker.address().state());
		return address;
	}
}
