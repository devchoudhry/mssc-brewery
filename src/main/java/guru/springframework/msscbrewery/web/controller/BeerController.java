package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.service.BearService;
import guru.springframework.msscbrewery.web.model.BeerDto;


@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

	
	private final BearService bearService;
	
	
	
	public BeerController(BearService bearService) {
		super();
		this.bearService = bearService;
	}



	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(getBearService().getBearById(beerId), HttpStatus.OK);
	}


	@PostMapping //To create a new Beer
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
	
		BeerDto savedDto = bearService.saveNewBeer(beerDto);
	
		HttpHeaders headers= new HttpHeaders();
		//Todo hostname to URL
		headers.add("Location", "/app/v1/beer" + savedDto.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
		
		
	}
	
	@PutMapping({"/{beerId}"}) // To update existing Beer
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
	
		bearService.updateBeer(beerId, beerDto);
	

		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
		
	}

	@DeleteMapping({"/{beerId}"}) // To update existing Beer
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable("beerId") UUID beerId) {
	
		bearService.deleteById(beerId);
	

		
		
	}

	public BearService getBearService() {
		return bearService;
	}
}
