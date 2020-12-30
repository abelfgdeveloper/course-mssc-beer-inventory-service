package guru.springframework.msscbeerinventoryservice.web.controller;

import guru.springframework.msscbeerinventoryservice.repository.BeerInventoryRepository;
import guru.springframework.msscbeerinventoryservice.web.mapper.BeerInventoryMapper;
import guru.springframework.msscbeerinventoryservice.web.model.BeerInventoryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

  private final BeerInventoryRepository beerInventoryRepository;
  private final BeerInventoryMapper beerInventoryMapper;

  @GetMapping("api/v1/beer/{beerId}/inventory")
  List<BeerInventoryDto> listBeersById(@PathVariable String beerId) {
    log.debug("Finding Inventory for beerId:" + beerId);

    return beerInventoryRepository
        .findAllByBeerId(beerId)
        .stream()
        .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
        .collect(Collectors.toList());
  }
}
