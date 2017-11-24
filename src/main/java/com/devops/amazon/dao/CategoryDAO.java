package com.devops.amazon.dao;

import java.util.List;

import com.devops.amazon.model.Category;

public interface CategoryDAO {
	public int create(Category c);
	public Category read(Category c);
	public int update(Category c);
	public int delete(Category c);
	public List<Category> readAll();
}
