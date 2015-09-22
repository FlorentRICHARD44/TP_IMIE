
console.log("Hello World");
if (process.argv[2] != undefined) {
    console.log("Hello " + process.argv[2]);
}

for (nbArg = 2; nbArg < process.argv.length; nbArg++) {
    console.log("Argument FOR " + (nbArg - 1) + " : " + process.argv[nbArg]);
}

process.argv.forEach(function(element, index, array) {
    if (index >= 2) {
        console.log("Argument FOREACH " + (index - 1) + " : " + element);
    }
})

console.log("---------- SOMME ----------------");
var somme = 0;
process.argv.forEach(function(element, index, array) {
    if (index >= 2 && !isNaN(element)) {
        somme = somme + parseInt(element);
    }
})
console.log("Somme = " + somme);

