package com.ucbcba.taller.repositories;

import com.ucbcba.taller.entities.Terminal;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Jp on 25/04/2017.
 */
@Transactional
public interface TerminalRepository extends CrudRepository<Terminal, Integer> {

}
