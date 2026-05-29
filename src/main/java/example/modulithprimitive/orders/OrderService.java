package example.modulithprimitive.orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

	public void placeOrder(String sku, long amountCents) {
		LOGGER.info("Placing order for {} cents: {}", amountCents, sku);
	}
}
