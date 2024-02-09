public interface IFork {
    /*
     * A philosopher (attempts to) acquire the fork.
     */
    void acquire() throws InterruptedException;

    /*
     * A philosopher releases the fork.
     */
    void release() ;
}
