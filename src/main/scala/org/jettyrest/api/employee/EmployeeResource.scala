package org.jettyrest.api.employee

import entities.Employee
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.jettyrest.api.EmployeeService
import java.net.URI
import javax.ws.rs.core.{UriBuilder, Response}
import javax.ws.rs._
import reflect.BeanProperty


@Service
@Path("/employees")
@Produces(Array("application/json"))
class EmployeeResource {
  @Autowired
  @BeanProperty
  var employeeService: EmployeeService[Employee, String] = null

  @POST
  def save(employee: Employee): Response = {
    val uuid: String = employeeService.save(employee)
    val uri: URI = UriBuilder.fromPath("/").build();
    return Response.created(uri).entity(new CreatedResponse(uuid)).build();
  }

  @GET
  @Path("{uuid}")
  def findById(@PathParam("uuid") uuid: String): Employee = {
    return employeeService.findById(uuid)
  }

  @DELETE
  def deleteById(uuid: String): Unit = {
    employeeService.delete(uuid)
  }
}