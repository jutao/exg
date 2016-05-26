package edu.jt.exg.service;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.jt.exg.dto.Callback;
import edu.jt.exg.dto.Task;
import edu.jt.exg.dto.Tasks;
import edu.jt.exg.dto.V_task;

@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ "application/javascript" })
public interface TaskService extends Serializable {
    @POST
    @Path("/createtask")
    public Callback CreateTask(Task task);
    
    @POST
    @Path("/gettask")
    public List<Tasks> GetTask(Task task);
    
    @POST
    @Path("/checktask")
    public Callback finderAlTask(Task task);
    
    @POST
    @Path("/gettaskbefore")
    public List<V_task> GetTaskBefore(Task task);
    
    @POST
    @Path("/gettaskalerdy")
    public List<V_task> GetTaskAlerdy(Task task);
    
    @POST
    @Path("/updateTask")
    public Callback UpDateTask(V_task v_task);
}
