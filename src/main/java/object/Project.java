package object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Project {
    private String projectName;
    private String projectCode;
    private String description;
}
