package com.ucbcba.taller.repositories;

import com.ucbcba.taller.entities.TerminalHistory;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Jp on 08/05/2017.
 */
@Transactional
public interface TerminalHistoryRepository extends CrudRepository<TerminalHistory,Integer>
{
}
