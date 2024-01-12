package com.ssdam.review.entity;

import com.ssdam.audit.Auditable;
import com.ssdam.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Review extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    private String content;

    public void addMember(Member member) {
        this.member = member;
        if (!member.getReviews().contains(this)) {
            member.getReviews().add(this);
        }
    }
}
