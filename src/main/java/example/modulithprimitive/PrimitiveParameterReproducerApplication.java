package example.modulithprimitive;

import example.modulithprimitive.orders.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimitiveParameterReproducerApplication implements CommandLineRunner {

  private final OrderService orders;

  public PrimitiveParameterReproducerApplication(OrderService orders) {
    this.orders = orders;
  }

  public static void main(String[] args) {
    SpringApplication.run(PrimitiveParameterReproducerApplication.class, args);
  }

  @Override
  public void run(String... args) {
    orders.placeOrder("spring-modulith-book", 4990L);
  }
}
