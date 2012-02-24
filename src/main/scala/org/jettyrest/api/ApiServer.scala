package org.jettyrest.api

import org.springframework.context.ApplicationContext
import com.google.common.base.Service
import org.springframework.context.support.ClassPathXmlApplicationContext


object ApiServer {
  def main(args: Array[String]) {
    val context: ApplicationContext = new ClassPathXmlApplicationContext("spring-server.xml");
    val service: Service = context.getBean(classOf[Service]);
    Runtime.getRuntime.addShutdownHook(new Thread {
      override def run() {
        service.stopAndWait
      }
    })
    service.startAndWait
  }
}