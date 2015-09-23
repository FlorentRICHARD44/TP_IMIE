var fs = require('fs');
var fileToRead = process.argv[2];
// Part Synchrone
if (fileToRead == undefined) {
    console.log("fichier à lire non renseigné");
} else {
     if (!fs.existsSync(fileToRead)) {
        console.log("fichier introuvable");
    } else {
        var fileContent = fs.readFileSync(fileToRead, 'utf8');
        var nbLines = fileContent.split('\n').length;
        console.log("Ce fichier comporte " + nbLines + " ligne(s)");
    }
}


// Part Asynchrone
var lectureFichier = function() {
    fs.readFile(fileToRead, 'utf8', function(err, data) {
        if (err) {
            console.log("Erreur lors de la lecture du fichier");
        } else {
            var nbLines = data.split('\n').length;
            console.log("Ce fichier comporte " + nbLines + " ligne(s)");
        }
    });
};
if (fileToRead == undefined) {
    console.log("fichier à lire non renseigné");
} else {
    fs.exists(fileToRead, function(exist) {
        if (!exist) {
            console.log("fichier introuvable");
        } else {
            lectureFichier();
        }
    });
}

