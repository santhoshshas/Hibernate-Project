package com.connection.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Customers 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int customerid;
private String name,area;
private long phnNo,boxNo;
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="customerid")
private List<Channels>channels;
}
