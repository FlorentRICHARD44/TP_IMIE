
// Imports
var express = require("express");
var path = require("path");
var bodyparser = require("body-parser");
var routerAdmin = require("./routes/admin");

// Arguments
var port = +process.argv[2] || 1234;

var app = express();

// Locals: store the elements during the life of the application.
app.locals.email = 'florentrichard@hotmail.fr';

// Gestion du moteur de vue
app.set('view engine', 'jade');
app.set("views", path.join(__dirname, 'view'));

// Middleware
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended: true}));

// Middleware de gestion des ressources statiques (CSS, IMG, ...)
app.use(express.static(path.join(__dirname, "public")));

// Ajout des routages
app.use('/admin', routerAdmin);
/* Middleware créé.

app.use(function(req, res, next) {
    console.log('middleware');
    next();
});
*/

// Middleware de gestion d'erreur
app.use(function(err, req, res, next) {
    console.log(err.stack);
    res.status(500).send("Erreur du serveur");
});


var server = app.listen(port, function() {
    console.log("server launched and listening on port " + port);
});


/* Routes sans Router


app.get('/', function(req, res) {
    console.log("une requete avec l'url " + req.url);
});

app.get('/admin', function(req, res) {
    res.status(403);
    res.end("Vous n'avez pas les droits d'accès");
});

// utilisation des patterns
app.get('/ab*cd/', function(req, res) {
    res.end("patern");
});

// 127.0.0.1:1234/api/users?id=x&name=y, récupération des parametres de la query dans l'url
app.get('/api/users', function(req, res) {
    res.json(req.query);
});
// 127.0.0.1:1234/api/users/4/address/1, récupération des parametres de l'url
app.get('/api_v1/users/:id/address/:addNb', function(req, res) {
    var user = req.params.id;
    var addNb = req.params.addNb;      
    res.send("Rue Victor Hugo<br>44400 REZE");
});

// 127.0.0.1:1234/truc , récupération des éléments du body (formulaires,  ....)
// body: id=3&addr=2
app.post("/truc/", function(req, res) {
    res.send("id = " + req.body.id + "<br>addr = " + req.body.addr); 
});

// 127.0.0.1:1234/truc , download fichier
app.get('/download', function(req, res) {
    res.download('./app.js');
});

// Redirection
app.get('/administration', function(req, res) {
    res.redirect("/admin");
});
*/

// Last route => donc pas d'url trouvée, => erreur 404
app.use(function(req, res, next) {
    res.status(404).send("Page non trouvée");
});

