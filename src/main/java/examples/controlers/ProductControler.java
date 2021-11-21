package examples.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import examples.domains.Category;
import examples.domains.Product;
import examples.repositories.CustomProductRepository;
import examples.repositories.Filter;
import examples.repositories.QueryOperator;

@RestController
@RequestMapping(path = "/api")
public class ProductControler {

	@Autowired
	CustomProductRepository repo;

	@GetMapping("/products")
	public @ResponseBody List<Product> getProducts() {
		
		List<Filter> filters = new ArrayList<>();

		Filter categories = Filter.builder()
				.field("category")
				.operator(QueryOperator.IN)
				.values(List.of(Category.MOBILE.name(), Category.TV_APPLIANCES.name()))
				.build();
		
		Filter lowRange = Filter.builder()
				.field("price")
				.operator(QueryOperator.LESS_THAN)
				.value("1000")
				.build();
		
		
		filters.add(lowRange);
		filters.add(categories);

		return repo.getQueryResult(filters);

	}

}
