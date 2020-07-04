package guru.springframework.msscbrewery.service;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.BeerDto;

public interface BearService {

	 public BeerDto getBearById(UUID beerId);

	public BeerDto saveNewBeer(BeerDto beerDto);

	public void updateBeer(UUID beerId, BeerDto beerDto);


	public void deleteById(UUID beerId);

}
