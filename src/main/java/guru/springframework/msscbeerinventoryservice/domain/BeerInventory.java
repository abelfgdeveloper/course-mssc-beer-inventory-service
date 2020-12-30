package guru.springframework.msscbeerinventoryservice.domain;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BeerInventory {

  @Id
  @Column(length = 36, updatable = false, nullable = false)
  private String id;

  @Version private Long version;

  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp createdDate;

  @UpdateTimestamp private Timestamp lastModifiedDate;

  private String beerId;
  private String upc;
  private Integer quantityOnHand = 0;

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID().toString();
  }

  public boolean isNew() {
    return this.id == null;
  }
}
