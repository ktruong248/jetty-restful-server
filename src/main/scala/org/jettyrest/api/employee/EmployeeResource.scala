package org.jettyrest.api.employee

import entities.Employee
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.jettyrest.api.EmployeeService
import java.net.URI
import javax.ws.rs.core.{UriBuilder, Response}
import javax.ws.rs._
import reflect.BeanProperty
import com.wordnik.swagger.core.{Api, ApiError, ApiErrors, ApiOperation}
import com.wordnik.swagger.jaxrs.JavaHelp


@Service
@Path("/employees")
@Produces(Array("application/json"))
class EmployeeResource extends JavaHelp {
  @Autowired
  @BeanProperty
  var employeeService: EmployeeService[Employee, String] = null

  @POST
  @ApiOperation(value = "create a new employee", notes = "", responseClass = "org.jettyrest.api.employee.CreatedResponse")
  def save(employee: Employee): Response = {
    val uuid: String = employeeService.save(employee)
    val uri: URI = UriBuilder.fromPath("/").build();
    return Response.created(uri).entity(new CreatedResponse(uuid)).build();
  }

  @GET
  @Path("/{uuid}")
  @ApiOperation(value = "Find employee by uuid", notes = "", responseClass = "org.jettyrest.api.entities.Employee")
  @ApiErrors(value = Array(
    new ApiError(code = 404, reason = "record not found")
  ))
  def findById(@PathParam("uuid") uuid: String): Employee = {
    return employeeService.findById(uuid)
  }

  @DELETE
  def deleteById(uuid: String): Unit = {
    employeeService.delete(uuid)
  }
}

