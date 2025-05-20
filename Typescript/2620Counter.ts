function createCounter(n: number): () => number {
    
    return function() {
        let counter = n;
        n++;
        return counter;
    }
}
