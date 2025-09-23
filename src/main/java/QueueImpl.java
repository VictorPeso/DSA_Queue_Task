public class QueueImpl<E> implements Queue<E>{
    private final E[] data;
    private int p;
    private final int maxsize;

    public QueueImpl(int len) {
        this.data = (E[])new Object[len];
        this.p = 0;
        this.maxsize = len;
    }

    public void push(E e) throws FullQueueException {
        if (isFull()) throw new FullQueueException("full");
        else{
            this.data[this.p++]=e;
        }
    }


    public E pop() throws EmptyQueueException {
        E object = null;
        if (isEmpty()) throw new EmptyQueueException("empty");
        else {
            object = this.data[0];
            for (int i = 0; i < this.maxsize; i++){
                if (i == (this.maxsize - 1)){
                    this.data[i] = null;
                }
                else{
                    this.data[i] = this.data[i+1];
                }
            }
            this.p--;
        }
        return object;
    }

    private boolean isFull() {
        return (this.p) == this.maxsize;
    }

    private boolean isEmpty() {
        return this.p == 0;
    }

    public int size() {
        return this.p;
    }
}
