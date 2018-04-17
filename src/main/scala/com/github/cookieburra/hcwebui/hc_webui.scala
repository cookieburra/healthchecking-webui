package com.github.cookieburra.hcwebui

import org.scalatra._

class hc_webui extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
