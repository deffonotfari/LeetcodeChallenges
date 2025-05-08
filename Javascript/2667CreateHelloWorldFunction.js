//Write a function createHelloWorld. It should return a new function that always returns "Hello World".
/**
 * @return {Function}
 */
function createHelloWorld() {
    return function(...args) {
        return "Hello World";
    };
}

 const f = createHelloWorld();
 f(); // "Hello World"
