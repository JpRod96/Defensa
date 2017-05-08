package com.ucbcba.taller.repositories;

import com.ucbcba.taller.entities.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Jp on 26/04/2017.
 */
@Transactional
public interface CategoryRepository extends CrudRepository<Category,Integer>
{
}
