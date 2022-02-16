package com.leetcode.DesignPatterns.src.zyr.dp.factorymethod;

public abstract class Factory {
  public abstract Product createProduct(String owner);
  public abstract void registerProduct(Product p);
  public abstract void getAllProductOwner();
  public Product create(String owner){
	  Product p=createProduct(owner);
	  registerProduct(p);
	  return p;
  }
}
