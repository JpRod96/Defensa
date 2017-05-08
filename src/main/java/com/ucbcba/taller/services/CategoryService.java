package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Category;

/**
 * Created by Jp on 26/04/2017.
 */
public interface CategoryService
{
    Iterable<Category> listAllCategory();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}
