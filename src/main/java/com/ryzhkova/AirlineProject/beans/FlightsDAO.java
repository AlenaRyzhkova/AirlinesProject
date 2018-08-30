package com.ryzhkova.AirlineProject.beans;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.annotation.Resource;

import com.ryzhkova.AirlineProject.beans.interfaces.FlightsDAOLocal;
import com.ryzhkova.AirlineProject.beans.interfaces.FlightsDAORemote;
import com.ryzhkova.AirlinesProject.entities.Flight;

@Stateless
public class FlightsDAO implements FlightsDAORemote, FlightsDAOLocal {
	
	@Resource
	SessionContext sessionContext;
	@PersistenceContext(unitName="AirlinesProject")
    EntityManager em;

    public FlightsDAO() {}
    
    public List<Flight> getAllFlights(){
    	return em.createNamedQuery("Flight.findAll").getResultList();
    }
}
