package com.github.cookieburra.hcwebui

import org.scalatra.test.scalatest._

class hc_webuiTests extends ScalatraFunSuite {

  addServlet(classOf[hc_webui], "/*")

  test("GET / on hc_webui should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
