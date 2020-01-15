package other.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {

    @Test
    public void should_success_when_offer_poll(){
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        queue.offer(new Patient("A",3));
        queue.offer(new Patient("B",8));
        queue.offer(new Patient("C",1));
        queue.offer(new Patient("D",10));
        assertThat(queue.poll().getSeverity()).isEqualTo(10);
        assertThat(queue.poll().getSeverity()).isEqualTo(8);
        assertThat(queue.poll().getSeverity()).isEqualTo(3);
        assertThat(queue.poll().getSeverity()).isEqualTo(1);
    }

    @Test
    public void should_success_when_peek_size_empty(){
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        queue.offer(new Patient("A",3));
        queue.offer(new Patient("B",8));
        queue.offer(new Patient("C",1));
        queue.offer(new Patient("D",10));
        assertThat(queue.peek().getSeverity()).isEqualTo(10);
        assertThat(queue.peek().getSeverity()).isEqualTo(10);
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.size()).isEqualTo(4);
    }
}
