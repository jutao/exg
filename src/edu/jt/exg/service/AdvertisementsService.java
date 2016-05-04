package edu.jt.exg.service;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import edu.jt.exg.dto.Advertisements;


@Produces( { "application/javascript" }) 
public interface AdvertisementsService extends Serializable {
    @GET
    @Path("/advertisements")
    public List<Advertisements> getAdvertisements();
    
}
