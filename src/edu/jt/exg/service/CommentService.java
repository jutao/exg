package edu.jt.exg.service;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.Comment;

@Consumes({ MediaType.APPLICATION_JSON })
@Produces( { "application/javascript" }) 
public interface CommentService extends Serializable {
    @POST
    @Path("/createcomment")
    public Callback createComment(Comment comment);
    
}
