package com.ryzhkova.AirlineProject.beans;

import com.ryzhkova.AirlineProject.beans.interfaces.CustomerDAOLocal;
import com.ryzhkova.AirlineProject.beans.interfaces.CustomerDAORemote;
import javax.ejb.Stateless;


@Stateless
public class CustomerDAO implements CustomerDAORemote, CustomerDAOLocal {

    
    public CustomerDAO() {
        // TODO Auto-generated constructor stub
    }

}
