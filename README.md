# Healthchecking WebUI #
This v. simple scala service reads files locate in a path specified.
Assuming a dot means the monitored service is up, and an exclamation mark means the opposite, it draws a history of the service statuses.
Colors added for clarity.

## Build & Run ##

```sh
$ cd Healthchecking_WebUI
$ sbt
> jetty:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
