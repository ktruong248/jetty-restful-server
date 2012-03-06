package org.jettyrest.api.employee

import com.wordnik.swagger.core.Api
import javax.ws.rs.{Produces, Path}
import org.springframework.stereotype.Service


@Service
@Path("/employees.json")
@Api(value = "/employees",
  description = "Operations about employees")
@Produces(Array("application/json"))
class EmployeeResourceJSON extends EmployeeResource  {

}