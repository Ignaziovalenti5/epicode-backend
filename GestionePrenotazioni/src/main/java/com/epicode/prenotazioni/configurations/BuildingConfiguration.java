package com.epicode.prenotazioni.configurations;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.prenotazioni.models.Address;
import com.epicode.prenotazioni.models.Building;
import com.epicode.prenotazioni.services.AddressService;

@Configuration
public class BuildingConfiguration {

	@Autowired
	AddressService addrServ;
	
	@Autowired
	ObjectProvider<Address> addressProvider;
	
	@Bean("building1")
	public Building building1() {
		Address add = addressProvider.getObject();
		addrServ.create(add);
		Building b = new Building();
		b.setAddress(add);
		b.setName("Name 1");
		return b;
	}
	
	@Bean("building2")
	public Building building2() {
		Address a = new Address(null, "City", "Street 49", "City");
		addrServ.create(a);
		Building b = new Building();
		b.setAddress(a);
		b.setName("Name 2");
		return b;
	}
	
	@Bean("building3")
	public Building building3() {
		Address a = addressProvider.getObject();
		addrServ.create(a);
		Building b = new Building();
		b.setAddress(a);
		b.setName("Name 3");
		return b;
	}
	
	@Bean("building4")
	public Building building4() {
		Address a = addressProvider.getObject();
		addrServ.create(a);
		Building b = new Building();
		b.setAddress(a);
		b.setName("Name 4");
		return b;
	}

}
