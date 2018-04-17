package com.github.cookieburra.hcwebui

import org.scalatra._
import scalate.ScalateSupport

import scala.io
import java.io.File

class StatusReader(path : String) {
  var hostStatus : Map[String,String]= Map()

  try {
    val hosts : Array[String] = new File(path).list()

    for (host <- hosts) {
      val handle = io.Source.fromFile(path ++ host)

      hostStatus +=  (host.substring(0, host.lastIndexOf('.')) -> handle.getLines.toArray.mkString(" ").trim.takeRight(50))
      handle.close
    }   
  }
  catch {
    case e: Exception => {
      println("Status directory does not exist!")
      hostStatus = Map("STATUS-DIRECTORY-MISSING" -> "...and that's not good :(")
    }   
  }
}

class hc_webui extends ScalatraServlet with ScalateSupport {

  get("/") {
    contentType= "text/html"

		val statusHistories = new StatusReader("./statusfiles/")
		scaml("index", "statusMap" -> statusHistories.hostStatus)
  }

}
