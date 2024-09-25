package casa.titanwalkers.common.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@MappedSuperclass
@SuperBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;
    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Generated
    @PrePersist // before persist is called for a new entity
    private void prePersist() {
        ZonedDateTime initTime = ZonedDateTime.now();
        createdAt = initTime;
        updatedAt = initTime;
    }

    @Generated
    @PreUpdate  // before update operation
    private void preUpdate() {
        updatedAt = ZonedDateTime.now();
    }

    @Generated
    public void setCreatedBy(Long userId) {
        createdBy = userId;
        updatedBy = userId;
    }

    @Generated
    public void setUpdatedBy(Long userId) {
        updatedBy = userId;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }
}