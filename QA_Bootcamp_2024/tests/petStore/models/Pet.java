package petStore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;
}
