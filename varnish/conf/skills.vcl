vcl 4.0;

backend query_backend {
  .host = "skill-query";
  .port = "8080";
}

backend command_backend {
  .host = "skill-command";
  .port = "8080";
}

sub vcl_recv {
  if (req.method == "GET") {
    set req.backend_hint = query_backend;
  }

  if (req.method != "GET") {
    set req.backend_hint = command_backend;
  }
}
