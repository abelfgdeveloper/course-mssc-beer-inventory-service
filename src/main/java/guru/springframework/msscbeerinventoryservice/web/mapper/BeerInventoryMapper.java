package guru.springframework.msscbeerinventoryservice.web.mapper;

import guru.springframework.msscbeerinventoryservice.domain.BeerInventory;
import guru.springframework.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeerInventoryMapper {

  private final DateMapper dateMapper;

  public BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO) {
    return BeerInventory.builder()
        .id(beerInventoryDTO.getId())
        .createdDate(dateMapper.asTimestamp(beerInventoryDTO.getCreatedDate()))
        .lastModifiedDate(dateMapper.asTimestamp(beerInventoryDTO.getLastModifiedDate()))
        .beerId(beerInventoryDTO.getBeerId())
        .quantityOnHand(beerInventoryDTO.getQuantityOnHand())
        .build();
  }

  public BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory) {
    return BeerInventoryDto.builder()
        .id(beerInventory.getId())
        .createdDate(dateMapper.asOffsetDateTime(beerInventory.getCreatedDate()))
        .lastModifiedDate(dateMapper.asOffsetDateTime(beerInventory.getLastModifiedDate()))
        .beerId(beerInventory.getBeerId())
        .quantityOnHand(beerInventory.getQuantityOnHand())
        .build();
  }
}
