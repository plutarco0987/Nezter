/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Nezter.ws.api.app;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.Nezter.Objects.User;

@WebService
public interface UserService{
	@WebMethod
    public User getUserById(int UserId)  throws Exception;
	@WebMethod
    public List<User> getAll()  throws Exception;
	
	@WebMethod
    public Boolean updateUser(User user)  throws Exception;
	
	@WebMethod
    public Boolean deleteUser(int userId)  throws Exception;
	
	@WebMethod
    public Boolean insertUser(User user)  throws Exception;
}
