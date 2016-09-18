package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by amits on 15/09/16.
 */
@Entity
@Table(name = "app_user")
@Getter
@Setter
public class Subscription extends BaseEntity {
}
