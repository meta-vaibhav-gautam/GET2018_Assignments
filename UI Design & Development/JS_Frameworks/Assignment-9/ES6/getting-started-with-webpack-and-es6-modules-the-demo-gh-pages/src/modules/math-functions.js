const sum = function(a, b){
    if(arguments.length == 1) {
        return function(b) {
            return a + b;
        }
    }
    return a + b;
};

export {sum};
