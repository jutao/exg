package edu.jt.exg.service;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.Order_master;
import edu.jt.exg.dto.Order_masters;


@Produces( { "application/javascript" }) 
public interface Order_masterService extends Serializable {
    @POST
    @Path("/createordermaster")
    public Callback CreateOrder_master(Order_master order_master);  
    
    @POST
    @Path("/getordermasterbefore")
    public List<Order_masters> GetOrder_masterBefore(Order_master order_master);  
    
    @POST
    @Path("/getordermasteralready")
    public List<Order_masters> GetOrder_masterAlready(Order_master order_master);  
    
    @POST
    @Path("/updateOrder_taskTo_30")
    public Callback UpdateOrder_taskTo_30(Order_masters order_masters); 
    
    
}
