package com.ucbcba.taller.services;
import com.ucbcba.taller.entities.Terminal;

/**
 * Created by Jp on 25/04/2017.
 */
public interface TerminalService {

    Iterable<Terminal> listAllTerminal();

    Terminal getTerminalById(Integer id);

    Terminal saveTerminal(Terminal terminal);

    void deleteTerminal(Integer id);
}
