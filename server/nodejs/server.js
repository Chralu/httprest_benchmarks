var express = require('express');
var app = express();
var fs = require("fs");

app.get('/:value', function (req, res) {
    console.log(">>> Request received")
    setTimeout(function() {
        res.writeHead(200, {"Content-Type": "text/plain"});
        res.end(req.params.value);
        console.log("<<< Response sent")
    }, 3000);
})

app.maxConnections = 100000
var server = app.listen(8081, function () {

  var host = server.address().address
  var port = server.address().port

  console.log("Example app listening at http://%s:%s", host, port)
});