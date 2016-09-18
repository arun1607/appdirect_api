package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by amits on 14/09/16.
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "accountIdentifier",
        "status",
        "parentAccountIdentifier"
})
@Getter
@Setter
@Entity
@Table(name = "app_account")
public class Account extends BaseEntity {
    @JsonProperty("accountIdentifier")
    private String accountIdentifier;
    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @JsonProperty("parentAccountIdentifier")
    private String parentAccountIdentifier;

    @PrePersist
    private void populateAccountIdentifier() {
        if (Objects.isNull(accountIdentifier)) {
            accountIdentifier = UUID.randomUUID().toString();
            status = AccountStatus.INITIALIZED;
        }
    }
}