package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Company;

/**
 * Created by Jp on 28/04/2017.
 */
public interface CompanyService
{
    Iterable<Company> listAllCompany();

    Company getCompanyById(Integer id);

    Company saveCompany(Company company);

    void deleteCompany(Integer id);
}
