// PART 1
//module.exports = 'Hello World';

// PART 2
//module.exports = function() {console.log('Hello World');};

// PART 3
//module.exports = {
//    name: 'toto',
//    test: function() {console.log('Hello World');}
//};


// PART 4
module.exports = function(msg, func) { func(msg.toUpperCase());};
