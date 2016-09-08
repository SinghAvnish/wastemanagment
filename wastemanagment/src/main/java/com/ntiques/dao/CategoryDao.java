package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.Category;
import java.util.List;


public interface CategoryDao
{
public void saveOrUpdate(Category category);

public void delete(String id);

public Category get(String id);

public Category getByName(String name);


public List<Category> list();
}