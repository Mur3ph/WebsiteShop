/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.project.exceptions;

import java.sql.SQLException;

/**
 *
 * @author paul
 */
@SuppressWarnings("serial")
public class DaoException extends SQLException {

    public DaoException() {
    }

    public DaoException(String aMessage) {
        super(aMessage);
    }
}
