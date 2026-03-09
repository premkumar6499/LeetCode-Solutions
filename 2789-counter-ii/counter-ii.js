/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let currentCount = init;
    return {
        increment: () => ++currentCount,
        decrement: () => --currentCount,
        reset: () => {
            currentCount = init;
            return currentCount;
        }
    };
};
