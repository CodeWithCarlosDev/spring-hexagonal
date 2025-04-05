package red.social.interesescomunes.group.infrastructure.input.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.social.interesescomunes.category.infrastructure.input.api.dto.request.CategoryRequest;
import red.social.interesescomunes.group.domain.enums.GroupStatus;
import red.social.interesescomunes.owner.infrastructure.input.api.dto.request.OwnerRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {
    private String name;
    private String description;
    private String location;
    private String imageUrl;
    private CategoryRequest category;
    private OwnerRequest owner;
    private GroupStatus status;
}