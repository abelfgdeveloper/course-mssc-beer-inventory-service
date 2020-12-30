package guru.springframework.msscbeerinventoryservice.web.model;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BeerInventoryDto {
  private String id;
  private OffsetDateTime createdDate;
  private OffsetDateTime lastModifiedDate;
  private String beerId;
  private Integer quantityOnHand;
}
