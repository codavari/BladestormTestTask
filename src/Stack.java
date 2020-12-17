public class Stack {
    private final Object[] buffer;
    private int size;

    public Stack(int capacity){
        buffer = new Object[capacity];
    }

    public void push(Object o){
        if (size >= buffer.length){
            throw new OutOfMemoryError();
        }
        buffer[size++] = o;
    }

    public Object pop(){
        if (size <= 0){
            return null;
        }
        return buffer[--size];
    }

    public boolean equals(Stack s) {
        return s.buffer == buffer;
    }
}
