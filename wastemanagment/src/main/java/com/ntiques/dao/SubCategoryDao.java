package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.SubCategory;
import java.util.List;


public interface SubCategoryDao
{
public void saveOrUpdate(SubCategory subcategory);

public void delete(String id);

public SubCategory get(String id);

public SubCategory getByName(String name);



public List<SubCategory> list();
}