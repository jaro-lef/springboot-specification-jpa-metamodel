package examples.repositories;



import java.util.List;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter

public class Filter {
    private String field;
    private QueryOperator operator;
    private String value;
    private List<String> values;//Used in case of IN operator  
	
}
