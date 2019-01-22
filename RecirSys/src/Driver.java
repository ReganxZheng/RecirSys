/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZhengJwh
 */
public class Driver {
    protected String driver_name;
    protected String driver_id;
    protected int driver_priority;

    public Driver(String name, String id, int priority) {
        this.driver_name=name;
        this.driver_id=id;
        this.driver_priority=priority;
    }
    public void setName(String name) {this.driver_name=name;}
    
    public void setID(String id) {this.driver_id=id;}
    
    public void setProirity(int priority) {this.driver_priority=priority;}
    
    public String getName() {return this.driver_name;}
    
    public String getId() {return this.driver_id;}
    
    public int getPriority() {return this.driver_priority;}
    
    @Override
    public String toString() {
        return "Priority: "+driver_priority+", Name: "+driver_name+", Id: "+driver_id;
    }
}
