package edu.jt.exg.service;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.jt.exg.dto.Category;


@Consumes( { MediaType.APPLICATION_JSON })
@Produces( { "application/javascript" }) 
public interface CategoryService extends Serializable {

    @GET
    @Path("/categorys")
    public List<Category> getData();
    
    
    @GET
    @Path("/categorys/code")
    public List<Category> getData(@PathParam("code") String code);
    
    

}
