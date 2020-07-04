/**
 * 
 */
package guru.springframework.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author devchoudhry
 *
 */
@Slf4j
@Service
public class BeerServiceImpl implements BearService {

	@Override
	public BeerDto getBearById(UUID beerId) {
		// TODO Auto-generated method stub
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Corona")
				.beerStyle("Pale").build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		// TODO Auto-generated method stub
		return BeerDto.builder().id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerid, BeerDto beerDto) {
		// TODO Auto-generated method stub
		log.debug("Deleting...");
	}

	@Override
	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting...");
	}

	

	
	

}
