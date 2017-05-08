package com.ucbcba.taller.repositories;

import com.ucbcba.taller.entities.Company;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Jp on 28/04/2017.
 */
@Transactional
public interface CompanyRepository extends CrudRepository<Company,Integer>
{

}
