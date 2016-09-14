package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.Category;
import java.util.List;


public interface CategoryDao
{
public void saveOrUpdate(Category category);

public void delete(int id);

public Category get(int id);

public Category getByName(String name);


public List<Category> list();
}