package mvctest.service;


import java.util.List;

import mvctest.domain.Hotel;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Hotel, Long> {
	@Override
	List<Hotel> findAll();

}
