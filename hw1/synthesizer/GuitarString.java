package synthesizer;

//Make sure this class is public
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {

        buffer = new ArrayRingBuffer<>((int) Math.round(SR / frequency));
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {

        for (int i = 0; i < buffer.fillCount(); i++) {
            buffer.dequeue();
        }
        for (int j = 0; j < buffer.capacity(); j++) {
            buffer.enqueue(Math.random() - 0.5);
        }

    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        buffer.enqueue(DECAY * 0.5 * (zero(buffer.dequeue()) + zero(buffer.peek())));
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // Return the correct thing.
        return zero(buffer.peek());
    }

    private double zero(Double n) {
        if (n == null) {
            return 0;
        }
        return n;
    }
}

