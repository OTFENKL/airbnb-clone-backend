package clone.airbnbpg.images;

import clone.airbnbpg.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @NoArgsConstructor
@Entity
public class ReviewImage {

    @Id @GeneratedValue
    @Column(name = "review_image_id")
    private Long id;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;
}
