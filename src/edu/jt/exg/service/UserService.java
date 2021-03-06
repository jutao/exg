package edu.jt.exg.service;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.User;
import edu.jt.exg.dto.UserCheck;


@Consumes( { MediaType.APPLICATION_JSON })
@Produces( { "application/javascript" }) 
public interface UserService extends Serializable {
    
    @POST
    @Path("/user/userid")
    public User getUserByID(User user);
    
    @POST
    @Path("/usercheck")
    public UserCheck userCheck(User user);
    
    @POST
    @Path("/createuser")
    public UserCheck CreateUser(User user);
    
    @POST
    @Path("/updateuser")
    public UserCheck UpdateUser(User user);
    
    
    
}
