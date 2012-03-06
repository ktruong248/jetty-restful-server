package org.jettyrest.api.employee

import org.springframework.stereotype.Service
import com.wordnik.swagger.core.Api
import javax.ws.rs.{Produces, Path}


@Service
@Path("/employees.xml")
@Api(value = "/employees",
  description = "Operations about employees")
@Produces(Array("application/xml"))
class EmployeeResourceXML extends EmployeeResource {

}