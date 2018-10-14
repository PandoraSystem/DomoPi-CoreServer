
var express = require('express')
var app = express()
var routes = require('./webapp/routes/main')

// Retrieve App Routes
routes(app)

app.listen(3000, function () {
  console.log('Example app listening on port 3000!')
})