package org.jettyrest.api.employee

import entities.Employee
import org.springframework.data.jpa.repository.JpaRepository


trait EmployeeRespository extends JpaRepository[Employee, String] {

}