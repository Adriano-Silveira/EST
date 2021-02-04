package Clases;

import java.util.LinkedList;
import java.util.Queue;

import com.opencsv.bean.CsvBindByName;

public class Producto {
	
	@CsvBindByName(column = "﻿Id")
	private int Id;
	
	@CsvBindByName(column = "name")
	private String name;
	
	@CsvBindByName(column = "prices.amountMax")
	private double prices_amountMax;

	private Queue<Stock> Stock= new LinkedList<Stock>();
	
	public Producto() {
		
	}
	
	public int getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public double getPrices_amountMax() {
		return prices_amountMax;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrices_amountMax(double prices_amountMax) {
		this.prices_amountMax = prices_amountMax;
	}
	
	public Queue<Stock> getStock() {
		return Stock;
	}

	public void setStock(Queue<Stock> stock) {
		Stock = stock;
	}

	@Override
	public String toString() {
		return "\tID | Nombre | Precio\n" + Id + " | " + name + " | " + prices_amountMax;	
	}
	
}
