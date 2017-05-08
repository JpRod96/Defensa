package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.TerminalHistory;

/**
 * Created by Jp on 08/05/2017.
 */
public interface TerminalHistoryService
{
    Iterable<TerminalHistory> listAllTerminalHistory();

    TerminalHistory getTerminalHistoryById(Integer id);

    TerminalHistory saveTerminalHistory(TerminalHistory location);

    void deleteTerminalHistory(Integer id);
}
