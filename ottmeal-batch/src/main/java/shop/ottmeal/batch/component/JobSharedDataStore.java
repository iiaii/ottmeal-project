package shop.ottmeal.batch.component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JobSharedDataStore<T> {

    private Queue<T> queue;

    public JobSharedDataStore() {
        this.queue = new LinkedList<>();
    }

    public void offer(List<T> objects) {
        objects.forEach(t -> offer(t));
    }

    public void offer(T object) {
        if (this.queue.contains(object)) {
            return;
        }
        this.queue.offer(object);
    }

    public T poll() {
        return this.queue.poll();
    }

    public int size() {
        return this.queue.size();
    }
}
